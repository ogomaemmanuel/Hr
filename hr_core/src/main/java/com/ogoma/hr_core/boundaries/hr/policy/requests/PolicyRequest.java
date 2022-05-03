package com.ogoma.hr_core.boundaries.hr.policy.requests;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PolicyRequest {
    @NotBlank(message = "Name required")
    private String name;
    @NotBlank(message = "Description required")
    private String description;
    private MultipartFile attachment;
    @NotNull(message = "Select department")
    private Long departmentId;

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
