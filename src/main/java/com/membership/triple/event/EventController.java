package com.membership.triple.event;

import com.membership.triple.Point.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final ReviewEventService reviewEventService;
    private final PointService pointService;

    @PostMapping("/events")
    public ResponseEntity event(@RequestBody Event event) {
        HttpStatus status = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        switch (event.getType()) {
            case REVIEW:
                return reviewEventService.splitEvent(event.toReview());
        }
        return new ResponseEntity(null, headers, status);
    }

    @GetMapping("/point")
    public ResponseEntity point(@RequestParam String userId) {
        return pointService.userPoint(userId);
    }


}
