package com.ogoma.vue_starter.vue_starter.utils;

import com.ogoma.vue_starter.vue_starter.authentication.CustomUserDetails;

public interface CustomUserDetailsProviderStrategy {
    public CustomUserDetails getCurrentUserDetails();
}
