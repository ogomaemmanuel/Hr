package com.ogoma.hr_core.utils;

import com.ogoma.hr_core.authentication.CustomUserDetails;

public interface CustomUserDetailsProviderStrategy {
    public CustomUserDetails getCurrentUserDetails();
}
