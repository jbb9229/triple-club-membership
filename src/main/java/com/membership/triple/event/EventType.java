package com.membership.triple.event;

import lombok.Getter;

@Getter
public enum EventType {

    REVIEW("REVIEW");
    /*
    AIRLINE("AIRLINE"),
    HOTEL("HOTEL"),
    TOUR("TOUR"),
    MENU("MENU"),
    WRONG_INF("WRONG_INF"),
    TRAVEL("TRAVEL"),
    FRIEND("FRIEND");
     */

    private final String type;

    EventType(String type) {
        this.type = type;
    }
}
