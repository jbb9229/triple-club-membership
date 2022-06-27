package com.membership.triple.event;

import com.membership.triple.review.AttachedPhoto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ReviewEvent {
    private EventType type;

    private EventAction action;

    private String userId;

    private String reviewId;

    private String content;

    private String placeId;

    private List<String> attachedPhotoIds;

    @Override
    public String toString() {
        return "ReviewEvent{" +
                "type=" + type +
                ", action=" + action +
                ", reviewId='" + reviewId + '\'' +
                ", content='" + content + '\'' +
                ", userId='" + userId + '\'' +
                ", placeId='" + placeId + '\'' +
                ", attachedPhotoIds=" + attachedPhotoIds +
                '}';
    }
}
