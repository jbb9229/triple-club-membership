package com.membership.triple.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PointResponse {

    private int status;
    private String message;
    private String userId;
    private int point;

    @Override
    public String toString() {
        return "{" +
                "\"status\":\"" + status +
                "\", \"message\":\"" + message +
                "\", \"userId\":\"" + userId +
                "\", \"point\":\"" + point +
                "\"}";
    }
}
