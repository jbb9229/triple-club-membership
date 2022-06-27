package com.membership.triple.reviewer;

import com.membership.triple.dto.reviewer.ReviewerRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewerService {

    private final ReviewerRepository reviewerRepository;

    @Transactional
    public Reviewer reviewerSave(ReviewerRequestDTO reviewerRequestDTO) {
        Optional<Reviewer> target = reviewerRepository.findById(reviewerRequestDTO.getUserId());
        if (target.isEmpty()) {
            return reviewerRepository.save(reviewerRequestDTO.toEntity());
        } else {
            return target.get();
        }
    }

}
