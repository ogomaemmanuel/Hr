package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

import java.util.Date;

public interface EmployeeResignationView {
    public Long getId();

    public Date getNoticeDate();

    public Date getResignationDate();

    public String getReason();

    public String getEmployeeFirstName();

    public String getEmployeeLastName();

    public default String getEmployeeFullName() {
        String lastName = this.getEmployeeLastName();
        String firstName = this.getEmployeeFirstName();
        if (null != firstName) {
            return firstName.concat(" ").concat(lastName);
        }
        return lastName;
    }
}

