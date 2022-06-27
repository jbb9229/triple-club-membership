package com.membership.triple.dto.place;

import com.membership.triple.place.Place;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaceRequestDTO {
    private String placeId;

    @Builder
    public PlaceRequestDTO(String placeId) {
        this.placeId = placeId;
    }

    public Place toEntity() {
        return Place.builder()
                    .placeId(placeId).build();
    }
}
