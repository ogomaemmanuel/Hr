package com.ogoma.vue_starter.vue_starter.boundaries.hr.employee_management.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DesignationDto {
    @NotBlank
    private String name;
    @NotNull
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
