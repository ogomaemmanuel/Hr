package com.ogoma.vue_starter.vue_starter.utils;

import com.ogoma.vue_starter.vue_starter.authentication.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static CustomUserDetails getCurrentUserDetails() {
        SecurityUtils securityUtils = new SecurityUtils();
        CustomUserDetails customUserDetails= securityUtils.getUserDetailsFromProvider();
        return customUserDetails;
    }
    public CustomUserDetails getUserDetailsFromProvider(){
        CustomUserDetailsProvider customUserDetailsProvider = new CustomUserDetailsProvider();
        CustomUserDetails customUserDetails = customUserDetailsProvider.provide();
        return customUserDetails;
    }
}
