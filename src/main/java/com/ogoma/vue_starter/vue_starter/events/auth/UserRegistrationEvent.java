package com.ogoma.vue_starter.vue_starter.events.auth;

import com.ogoma.vue_starter.vue_starter.entities.User;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

public class UserRegistrationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */

    private User user;

    public UserRegistrationEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
    public User getUser() {
        return user;
    }
}
