package com.ogoma.vue_starter.vue_starter.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint  implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        String requestedWithHeader = request.getHeader("X-Requested-With");
        if( "XMLHttpRequest".equals(requestedWithHeader)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else {
            response.sendRedirect("/login");
        }



      //  response.sendRedirect("/login");
    }
}
