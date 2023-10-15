package com.ogoma.hr_core.utils;

import com.ogoma.hr_core.authentication.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomUserDetailsProvider implements CustomUserDetailsProviderStrategy {

    public CustomUserDetails getCurrentUserDetails() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        return (CustomUserDetails) authentication.getPrincipal();
    }
}
