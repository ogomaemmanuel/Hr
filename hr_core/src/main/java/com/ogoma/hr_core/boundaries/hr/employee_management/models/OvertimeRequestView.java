package com.ogoma.hr_core.boundaries.hr.employee_management.models;

import java.util.Date;

public interface OvertimeRequestView {
    public Long getId();

    public String getEmployeeFirstName();

    public String getEmployeeLastName();

    public Long getOvertimeHours();

    public Date getOvertimeDate();

    public String getDescription();

    public String getStatus();

    public String getApproverName();

    public default String getEmployeeFullName() {
        String lastName = this.getEmployeeLastName();
        String firstName = this.getEmployeeFirstName();
        if (null != firstName) {
            return firstName.concat(" ").concat(lastName);
        }
        return lastName;
    }

}
