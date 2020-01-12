package com.ogoma.vue_starter.vue_starter.boundaries.notifications.entities;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notifications")
@EntityListeners(AuditingEntityListener.class)
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isRead;
    private String message;
    @Column(name = "user_id")
    private Long userId;
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public Notification setId(Long id) {
        this.id = id;
        return this;
    }

    public Boolean getRead() {
        return isRead;
    }

    public Notification setRead(Boolean read) {
        isRead = read;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Notification setMessage(String message) {
        this.message = message;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Notification setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Notification setUser(User user) {
        this.user = user;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Notification setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Notification setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }
}
