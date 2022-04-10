package com.ogoma.vue_starter.vue_starter.boundaries.company.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NotificationSettingModel {
    private Long id;
    @NotNull(message = "Setting value is required")
    private Boolean notify;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getNotify() {
        return notify;
    }
    public void setNotify(Boolean notify) {
        this.notify = notify;
    }
}
