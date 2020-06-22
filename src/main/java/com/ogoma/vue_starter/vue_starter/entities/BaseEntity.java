package com.ogoma.vue_starter.vue_starter.entities;

import javax.persistence.MappedSuperclass;
import javax.persistence.PreRemove;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    private boolean deleted;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @PreRemove
    public void updateDeleteState() {
        this.deleted = true;
        this.deletedAt = Date.from(Instant.now());
    }
}
