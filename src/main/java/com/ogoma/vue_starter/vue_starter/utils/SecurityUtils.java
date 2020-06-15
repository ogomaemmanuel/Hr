package com.ogoma.vue_starter.vue_starter.utils;

import com.ogoma.vue_starter.vue_starter.authentication.CustomUserDetails;

public class SecurityUtils {
    private static CustomUserDetailsProvider customUserDetailsProvider = new CustomUserDetailsProvider();
    public static CustomUserDetails getCurrentUserDetails() {
        CustomUserDetails customUserDetails= customUserDetailsProvider.getCurrentUserDetails();
        return customUserDetails;
    }
    /**
     *  Used for providing A mock CustomUserDetailsProvider when running tests
     *  https://stackoverflow.com/questions/250137/refactoring-static-method-static-field-for-testing
     */
    static void setCustomUserDetailsProvider(CustomUserDetailsProvider customUserDetailsProvider) {
        SecurityUtils.customUserDetailsProvider = customUserDetailsProvider;
    }
}
