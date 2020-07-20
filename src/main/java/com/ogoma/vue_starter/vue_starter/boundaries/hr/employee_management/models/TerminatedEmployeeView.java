package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

import java.util.Date;

public interface TerminatedEmployeeView {
    public Long getId();

    public String getEmployeeFirstName();

    public String getEmployeeLastName();

    public Date getTerminationDate();

    public Date getNoticeDate();

    public String getReason();

    public String departmentName();

    public String getTerminationType();
    public default String getEmployeeFullName() {
        String lastName = this.getEmployeeLastName();
        String firstName = this.getEmployeeFirstName();
        if (null != firstName) {
            return firstName.concat(" ").concat(lastName);
        }
        return lastName;
    }
}
