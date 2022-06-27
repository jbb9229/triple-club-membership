package com.membership.triple.event;

import com.membership.triple.Point.PointService;
import com.membership.triple.model.ReviewResponse;
import com.membership.triple.place.PlaceService;
import com.membership.triple.review.Review;
import com.membership.triple.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewEventService {

    private final ReviewService reviewService;
    private final PointService pointService;
    private final PlaceService placeService;

    public ResponseEntity splitEvent(ReviewEvent event) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        switch (event.getAction()) {
            case ADD:
                return addReview(event);
            case MOD:
                return modReview(event);
            case DELETE:
                return delReview(event);
        }
        return new ResponseEntity(null, status);
    }

    public ResponseEntity addReview(ReviewEvent event) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            Review review = reviewService.ReviewSave(event);
            return new ResponseEntity(ReviewResponse.builder()
                                                    .status(200)
                                                    .reviewId(review.getReviewId())
                                                    .message("리뷰가 저장되었습니다.")
                                                    .build().toString(), headers, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity(ReviewResponse.builder()
                                                    .status(400)
                                                    .reviewId(event.getReviewId())
                                                    .message(exception.getMessage())
                                                    .build().toString(), headers, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity modReview(ReviewEvent event) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            Review review = reviewService.reviewUpdate(event);
            return new ResponseEntity(ReviewResponse.builder()
                    .status(200)
                    .reviewId(review.getReviewId())
                    .message("리뷰가 수정되었습니다.")
                    .build().toString(), headers, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity(ReviewResponse.builder()
                    .status(400)
                    .reviewId(event.getReviewId())
                    .message(exception.getMessage())
                    .build().toString(), headers, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity delReview(ReviewEvent event) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            Review review = reviewService.reviewDelete(event);
            return new ResponseEntity(ReviewResponse.builder()
                    .status(200)
                    .reviewId(review.getReviewId())
                    .message("리뷰가 삭제되었습니다.")
                    .build().toString(), headers, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity(ReviewResponse.builder()
                    .status(400)
                    .reviewId(event.getReviewId())
                    .message(exception.getMessage())
                    .build().toString(), headers, HttpStatus.BAD_REQUEST);
        }
    }

}
