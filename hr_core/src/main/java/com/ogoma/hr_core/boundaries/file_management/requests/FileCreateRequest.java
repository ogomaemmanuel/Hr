package com.ogoma.hr_core.boundaries.file_management.requests;

import com.ogoma.hr_core.boundaries.file_management.entities.File;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class FileCreateRequest {
    @NotBlank(message = "Name is required")
    private String name;
    private File.Type type;
    private Long parentId;
    private MultipartFile attachment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File.Type getType() {
        return type;
    }

    public void setType(File.Type type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public MultipartFile getAttachment() {
        return attachment;
    }

    public void setAttachment(MultipartFile attachment) {
        this.attachment = attachment;
    }
}
