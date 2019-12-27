package com.ogoma.vue_starter.vue_starter.boundaries.notifications.entities;

import com.ogoma.vue_starter.vue_starter.entities.User;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isRead;
    private String message;
    @Column(name = "user_id")
    private Long userId;
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



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
}
