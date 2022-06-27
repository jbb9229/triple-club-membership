package com.membership.triple.event;

import com.membership.triple.review.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.UUID;

@RestController
public class EventController {

    @PostMapping("/events")
    public ResponseEntity<ReviewEvent> event(@RequestBody ReviewEvent event) {
        event.setType(EventType.REVIEW);

        return new ResponseEntity<>(event, HttpStatus.OK);
    }

}
