package com.ogoma.hr_core.boundaries.hr.employee_management.models;

import java.util.Date;

public interface EmployeeQuery {
    public Long getId();

    public String getFirstName();

    public String getLastName();

    public Date getDateOfBirth();

    public String getDesignation();

    public String getEmail();

    public String getPhone();

    public Date getJoiningDate();

    public String getDepartment();

    public String avatarUrl();

    //    @Value("#{target.firstName} #{target.lastName}")
    default String getFullName() {
        String lastName = null;
        if (null != getLastName()) {
            lastName = getLastName();
        }
        if (null != getFirstName()) {
            return getFirstName().concat(" ").concat(lastName);
        }
        return "";
    }
}
