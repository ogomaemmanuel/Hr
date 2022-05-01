package com.ogoma.vue_starter.vue_starter.boundaries.file_management.requests;

import com.ogoma.vue_starter.vue_starter.boundaries.file_management.entities.File;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class FileCreateRequest {
    private String name;
    private File.Type type;
    private Long parentId;


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
}
