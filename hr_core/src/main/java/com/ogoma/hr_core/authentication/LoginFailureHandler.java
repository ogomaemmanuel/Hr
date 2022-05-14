package com.ogoma.hr_core.authentication;

import com.google.gson.Gson;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String, Object> errors = new
                HashMap<>();
        request.getSession().setAttribute("simpleAuthenitcationLoginError", exception.getClass().getName());
        if (exception instanceof UsernameNotFoundException) {
            errors.put("msg", "Invalid login details");
            errors.put("state", "danger");
        } //Invalid credentials
        else if (exception instanceof BadCredentialsException) {
            errors.put("msg", "Invalid login details");
            errors.put("state", "danger");
        } //When account has been locked
        else if (exception instanceof LockedException) {
            errors.put("msg", exception.getMessage());
            errors.put("state", "danger");
        } //When credentials have expired
        else if (exception instanceof CredentialsExpiredException) {
            // messageSource.getMessage("login.accountExpired", new Object[0], new Locale("el"));
        } //When account has expired( though this one will never happen)
        else if (exception instanceof AccountExpiredException) {
            // messageSource.getMessage("login.accountExpired", new Object[0], new Locale("el"));

        } else if (exception instanceof AccountStatusException) {
            errors.put("msg", "Verify your account using the verification link that was sent to your email during registration");
            errors.put("state", "danger");

        }  else if (exception instanceof UsernameNotFoundException) {
            errors.put("msg", "No user found");
            errors.put("state", "danger");

        } else {
            exception.printStackTrace();
            errors.put("msg", "There was an error during the login process");
            errors.put("state", "danger");
        }
        Gson gson = new Gson();
        response.setStatus(400);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(errors));
        response.getWriter().flush();
        response.getWriter().close();
    }
}

