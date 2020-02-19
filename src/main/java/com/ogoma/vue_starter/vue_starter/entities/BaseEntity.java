package com.ogoma.vue_starter.vue_starter.entities;

import javax.persistence.MappedSuperclass;
import javax.persistence.PreRemove;

@MappedSuperclass
public abstract class BaseEntity {
    private boolean deleted;
    @PreRemove
    public void updateDeleteState() {
        this.deleted = true;
    }
}
