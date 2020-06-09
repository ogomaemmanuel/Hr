package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

public class DesignationUpdateRequest {

    private String name;
    private Long departmentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
