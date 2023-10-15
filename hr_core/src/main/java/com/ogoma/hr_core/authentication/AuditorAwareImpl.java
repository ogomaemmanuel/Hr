package com.ogoma.hr_core.authentication;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }
        if (authentication.getPrincipal() instanceof CustomUserDetails) {
            User user = ((CustomUserDetails) authentication.getPrincipal()).getUser();
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
