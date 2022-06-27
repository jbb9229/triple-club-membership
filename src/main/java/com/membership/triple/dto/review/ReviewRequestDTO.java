package com.membership.triple.dto.review;

import com.membership.triple.place.Place;
import com.membership.triple.review.AttachedPhoto;
import com.membership.triple.review.Review;
import com.membership.triple.reviewer.Reviewer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@NoArgsConstructor
public class ReviewRequestDTO {

    private String reviewId;
    private String content;
    private Set<AttachedPhoto> attachedPhotos;
    private Reviewer reviewer;
    private Place place;

    @Builder
    public ReviewRequestDTO(String reviewId, String content, Set<AttachedPhoto> attachedPhotos, Reviewer reviewer, Place place) {
        this.reviewId = reviewId;
        this.content = content;
        this.attachedPhotos = attachedPhotos;
        this.reviewer = reviewer;
        this.place = place;
    }

    public Review toEntity() {
        return Review.builder()
                .reviewId(reviewId)
                .content(content)
                .attachedPhotos(attachedPhotos)
                .reviewer(reviewer)
                .place(place)
                .build();
    }

}
