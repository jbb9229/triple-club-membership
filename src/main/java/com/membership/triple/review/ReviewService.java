package com.membership.triple.review;

import com.membership.triple.Point.PointService;
import com.membership.triple.dto.place.PlaceRequestDTO;
import com.membership.triple.dto.review.ReviewRequestDTO;
import com.membership.triple.dto.reviewer.ReviewerRequestDTO;
import com.membership.triple.event.ReviewEvent;
import com.membership.triple.place.Place;
import com.membership.triple.place.PlaceService;
import com.membership.triple.reviewer.Reviewer;
import com.membership.triple.reviewer.ReviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final PointService pointService;
    private final PlaceService placeService;
    private final ReviewerService reviewerService;
    private final AttachedPhotoRepository attachedPhotoRepository;

    @Transactional
    public Review ReviewSave(ReviewEvent event) {
        Set<AttachedPhoto> attachedPhotos = event.getAttachedPhotoIds().stream()
                .map(ids -> new AttachedPhoto(ids))
                .collect(Collectors.toSet());

        Place reviewPlace = placeService.placeSave(PlaceRequestDTO.builder().placeId(event.getPlaceId()).build());
        Reviewer reviewer = reviewerService.reviewerSave(ReviewerRequestDTO.builder().userId(event.getUserId()).build());

        ReviewRequestDTO requestDTO = ReviewRequestDTO.builder()
                                                      .reviewId(event.getReviewId())
                                                      .content(event.getContent())
                                                      .place(reviewPlace)
                                                      .reviewer(reviewer)
                                                      .build();
        Optional<Review> target = reviewRepository.findByReviewId(requestDTO.getReviewId());
        if (target.isEmpty()) {
            Review review = reviewRepository.save(requestDTO.toEntity());
            for (AttachedPhoto photo : attachedPhotos) {
                photo.setReview(review);
            }
            review.setAttachedPhotos(attachedPhotos);
            Set<Review> placeReviews = reviewPlace.getReviews();
            review.setPoints(pointService.countAddReview(review, placeReviews.size()));
            reviewPlace.placeUpdate(review);
            return review;
        } else {
            throw new IllegalArgumentException("해당 리뷰ID는 이미 존재합니다.");
        }

    }

    @Transactional
    public Review reviewUpdate(ReviewEvent event) {
        Review review = reviewRepository.findByReviewId(event.getReviewId())
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다."));
        Set<AttachedPhoto> photos = new HashSet<>();
        for (String photoId : event.getAttachedPhotoIds()) {
            AttachedPhoto photo = AttachedPhoto.builder().attachedPhotoId(photoId).build();
            photo.setReview(review);
            photos.add(photo);
        }
        pointService.countModReview(review, event.getContent(), photos.size()).forEach(point -> review.getPoints().add(point));
        attachedPhotoRepository.deleteByReview(review);
        review.reviewUpdate(event.getContent(), photos);

        return review;
    }

    @Transactional
    public Review reviewDelete(ReviewEvent event) {
        Review review = reviewRepository.findByReviewId(event.getReviewId())
                .orElseThrow(() -> new IllegalArgumentException("해당 리뷰를 찾을 수 없습니다."));
        pointService.countDelReview(review).forEach(point -> review.getPoints().add(point));
        attachedPhotoRepository.deleteByReview(review);
        review.reviewDelete();
        return review;
    }

}
