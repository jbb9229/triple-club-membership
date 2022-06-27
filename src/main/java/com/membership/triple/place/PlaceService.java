package com.membership.triple.place;

import com.membership.triple.dto.place.PlaceRequestDTO;
import com.membership.triple.review.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    @Transactional
    public Place placeSave(PlaceRequestDTO placeRequestDTO) {
        Optional<Place> target = placeRepository.findById(placeRequestDTO.getPlaceId());
        if (target.isEmpty()) {
            return placeRepository.save(placeRequestDTO.toEntity());
        } else {
            return target.get();
        }
    }

}
