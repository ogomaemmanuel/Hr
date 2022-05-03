package com.ogoma.hr_core.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationEntryPoint   extends LoginUrlAuthenticationEntryPoint {
    public CustomAuthenticationEntryPoint(String loginUrl) {
        super(loginUrl);
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        String requestedWithHeader = request.getHeader("X-Requested-With");
        if( "XMLHttpRequest".equals(requestedWithHeader)){
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else {
            super.commence(request,response,authException);
        }



      //  response.sendRedirect("/login");
    }
}
