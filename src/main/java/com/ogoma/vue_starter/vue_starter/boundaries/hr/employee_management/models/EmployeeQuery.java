package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

import java.util.Date;

public interface EmployeeQuery {
    public Long getId();
    public Long getFirstName();
    public Long getLastName();
    public Date getDateOfBirth();
    public String getDesignation();
    public Long getEmail();
    public String getPhone();
    public Date getJoiningDate();
    public String avatarUrl();
    public default String fullName(){
        return this.getFirstName()+" "+this.getLastName();
    }
}
