package com.ogoma.hr_core.events.auth;

import com.ogoma.hr_core.boundaries.access_control.entities.PasswordReset;
import org.springframework.context.ApplicationEvent;

public class PasswordResetEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private PasswordReset passwordReset;
    public PasswordResetEvent(Object source, PasswordReset passwordReset) {
        super(source);
        this.passwordReset=passwordReset;
    }

    public PasswordReset getPasswordReset() {
        return passwordReset;
    }
}
