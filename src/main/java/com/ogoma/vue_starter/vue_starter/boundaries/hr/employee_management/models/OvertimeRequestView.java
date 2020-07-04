package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

public interface OvertimeRequestView {
    public Long getId();

    public String getEmployeeFirstName();

    public String getEmployeeLastName();

    public Long getOvertimeHours();

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
