package com.membership.triple.Point;

import com.membership.triple.dto.point.PointRequestDTO;
import com.membership.triple.model.PointResponse;
import com.membership.triple.model.ReviewResponse;
import com.membership.triple.review.Review;
import com.membership.triple.reviewer.Reviewer;
import com.membership.triple.reviewer.ReviewerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;
    private final ReviewerRepository reviewerRepository;

    public Point newPoint(Review review, PointType type) {
        return PointRequestDTO.builder()
                              .review(review)
                              .reviewer(review.getReviewer())
                              .type(type)
                              .score(type.getPoint())
                              .build()
                              .toEntity();
    }

    public Set<Point> countAddReview(Review review, int placeReviewSize) {
        Set<Point> points = new HashSet<>();

        if (review.getContent().length() > 0) {
            points.add(newPoint(review, PointType.ADD_REVIEW_CONTENT));
        }
        if (review.getAttachedPhotos().size() > 0) {
            points.add(newPoint(review, PointType.ATTACH_REVIEW_PHOTO));
        }
        if (placeReviewSize == 0) {
            points.add(newPoint(review, PointType.ADD_REVIEW_FIRST_PLACE));
        }

        return points;
    }

    public Set<Point> countModReview(Review review, String newContent, int photosize) {
        Set<Point> points = new HashSet<>();

        if (review.getContent().length() == 0 && newContent.length() > 0) {
            points.add(newPoint(review, PointType.ADD_REVIEW_CONTENT));
        } else if (review.getContent().length() > 0 && newContent.length() == 0) {
            points.add(newPoint(review, PointType.DELETE_REVIEW_CONTENT));
        }

        if (review.getAttachedPhotos().size() == 0 && photosize > 0) {
            points.add(newPoint(review, PointType.ATTACH_REVIEW_PHOTO));
        } else if (review.getAttachedPhotos().size() > 0 && photosize == 0) {
            points.add(newPoint(review, PointType.DETACH_REVIEW_PHOTO));
        }
        return points;
    }

    public Set<Point> countDelReview(Review review) {
        Set<Point> points = new HashSet<>();
        Optional<Point> firstVisitPoint = pointRepository.findByReviewAndType(review, PointType.ADD_REVIEW_FIRST_PLACE);
        if (firstVisitPoint.isPresent()) {
            points.add(newPoint(review, PointType.DELETE_REVIEW_FIRST_PLACE));
        }
        if (review.getContent().length() > 0) {
            points.add(newPoint(review, PointType.DELETE_REVIEW_CONTENT));
        }
        if (review.getAttachedPhotos().size() > 0) {
            points.add(newPoint(review, PointType.DETACH_REVIEW_PHOTO));
        }
        return points;
    }

    public ResponseEntity userPoint(String userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Optional<Reviewer> reviewer = reviewerRepository.findById(userId);
        if (reviewer.isPresent()) {
            try {
                return new ResponseEntity(PointResponse.builder()
                        .status(200)
                        .userId(userId)
                        .message("포인트 조회 완료했습니다.")
                        .point(pointRepository.sumPointByUser(reviewer.get()))
                        .build().toString(), headers, HttpStatus.OK);
            } catch (IllegalArgumentException exception) {
                return new ResponseEntity(PointResponse.builder()
                        .status(400)
                        .userId(userId)
                        .message("유저가 조회되지 않습니다.")
                        .point(0)
                        .build().toString(), headers, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity(PointResponse.builder()
                    .status(400)
                    .userId(userId)
                    .message("유저가 조회되지 않습니다.")
                    .point(0)
                    .build().toString(), headers, HttpStatus.BAD_REQUEST);
        }
    }
}

