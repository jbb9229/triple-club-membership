package com.membership.triple.dto.point;

import com.membership.triple.Point.Point;
import com.membership.triple.Point.PointType;
import com.membership.triple.review.Review;
import com.membership.triple.reviewer.Reviewer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PointRequestDTO {

    private Reviewer reviewer;
    private Review review;
    private PointType type;
    private int score;

    @Builder
    public PointRequestDTO(Reviewer reviewer, Review review, PointType type, int score) {
        this.reviewer = reviewer;
        this.review = review;
        this.type = type;
        this.score = score;
    }

    public Point toEntity() {
        return Point.builder()
                    .reviewer(reviewer)
                    .review(review)
                    .type(type)
                    .score(score)
                    .build();
    }

}
