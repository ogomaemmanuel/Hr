package com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.events;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.leave_management.entities.LeaveRequestHistory;
import org.springframework.web.util.UriComponentsBuilder;

public class LeaveRequestEventData {
    private final LeaveRequestHistory leaveRequestHistory;
    private final UriComponentsBuilder uriComponentsBuilder;

    public LeaveRequestEventData(LeaveRequestHistory leaveRequestHistory,
                                 UriComponentsBuilder uriComponentsBuilder
    ) {
        this.leaveRequestHistory = leaveRequestHistory;
        this.uriComponentsBuilder = uriComponentsBuilder;

    }
    public LeaveRequestHistory getLeaveRequestHistory() {
        return leaveRequestHistory;
    }
    public UriComponentsBuilder getUriComponentsBuilder() {
        return uriComponentsBuilder;
    }
}
