package com.membership.triple.event;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Event {
    private EventType type;

    private EventAction action;

    private String userId;

    private String reviewId;

    private String content;

    private String placeId;

    private List<String> attachedPhotoIds;

    public ReviewEvent toReview() {
        return ReviewEvent.builder()
                          .type(type)
                          .action(action)
                          .userId(userId)
                          .reviewId(reviewId)
                          .content(content)
                          .placeId(placeId)
                          .attachedPhotoIds(attachedPhotoIds)
                          .build();
    }
}
