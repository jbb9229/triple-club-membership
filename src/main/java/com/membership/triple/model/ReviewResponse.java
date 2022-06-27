package com.membership.triple.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ReviewResponse {

    private int status;
    private String message;
    private String reviewId;

    @Override
    public String toString() {
        return "{" +
                "\"status\":\"" + status +
                "\", \"message\":\"" + message +
                "\", \"reviewId\":\"" + reviewId +
                "\"}";
    }
}
