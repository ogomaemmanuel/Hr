package com.ogoma.vue_starter.vue_starter.events.auth;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.PasswordReset;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import org.springframework.context.ApplicationEvent;

import java.util.Map;

public class UserRegistrationEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */

    private Map<String, Object> registrationData;

    public UserRegistrationEvent(Object source, Map<String, Object> registrationData) {
        super(source);
        this.registrationData = registrationData;
    }

    public User getUser() {
        return (User) registrationData.get("user");
    }

    public PasswordReset getPasswordReset() {
        return (PasswordReset) registrationData.get("token");
    }
}
