package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

import java.util.Date;

public interface TerminatedEmployeeView {
    public Long getId();

    public String getEmployeeFirstName();

    public String getEmployeeLastName();

    public Date getTerminationDate();

    public Date getNoticeDate();

    public String getReason();

    public String getTerminationReason();
}
