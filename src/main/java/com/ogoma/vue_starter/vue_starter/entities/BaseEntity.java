package com.ogoma.vue_starter.vue_starter.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User_;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    private boolean deleted;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    @PreRemove
    public void updateDeleteState() {
        this.deleted = true;
        this.deletedAt = Date.from(Instant.now());
    }

    @ManyToOne
    @CreatedBy
    @JsonIgnoreProperties(User_.USER_ROLES)
    private User createdBy;

    public boolean isDeleted() {
        return deleted;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
