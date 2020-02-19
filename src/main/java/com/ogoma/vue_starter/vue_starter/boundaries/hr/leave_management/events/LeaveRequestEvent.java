package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.events;

import org.springframework.context.ApplicationEvent;

public class LeaveRequestEvent extends ApplicationEvent {

    private final LeaveRequestEventData requestEventData;

    public LeaveRequestEvent(Object source, LeaveRequestEventData requestEventData) {
        super(source);

        this.requestEventData = requestEventData;
    }

    public LeaveRequestEventData getRequestEventData() {
        return requestEventData;
    }
}
