package com.membership.triple.event;

import lombok.Getter;

@Getter
public enum EventAction {
    ADD("ADD"),
    MOD("MOD"),
    DELETE("DELETE");
    /*
    BOOK("BOOK"),
    CANCEL("CANCEL"),
    INVITE("INVITE");
     */

    private final String action;

    EventAction(String action) {
        this.action = action;
    }
}
