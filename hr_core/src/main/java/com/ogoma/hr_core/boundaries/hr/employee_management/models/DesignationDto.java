package com.ogoma.hr_core.boundaries.hr.employee_management.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DesignationDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "Select department")
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
