package com.ogoma.vue_starter.vue_starter.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CustomLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // you can get the details of the user logging out and save the logout activity in the db with user datails;
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email =  authUser.getUsername();
    }
}
