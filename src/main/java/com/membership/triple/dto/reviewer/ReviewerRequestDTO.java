package com.membership.triple.dto.reviewer;


import com.membership.triple.reviewer.Reviewer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReviewerRequestDTO {

    private String userId;

    @Builder
    public ReviewerRequestDTO(String userId) {
        this.userId = userId;
    }

    public Reviewer toEntity() {
        return Reviewer.builder().userId(userId).build();
    }
}
