package com.ogoma.vue_starter.vue_starter.config;

import com.ogoma.vue_starter.vue_starter.authentication.CustomAuthenticationEntryPoint;
import com.ogoma.vue_starter.vue_starter.authentication.CustomLogoutHandler;
import com.ogoma.vue_starter.vue_starter.authentication.LoginFailureHandler;
import com.ogoma.vue_starter.vue_starter.authentication.LoginSuccessfulHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppSecurityConfig extends  WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }
    @Autowired
    CustomLogoutHandler customLogoutHandler;

    protected AppSecurityConfig() {
        super();
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        //        Register application requests to be ignored by Spring Security
        webSecurity.ignoring().antMatchers("/resources/**","/dist/**","/resources/static/**", "/css/**", "/scss/**", "/images/**", "/photos/**", "/js/**", "/fonts/**", "/plugins/**", "/theme/**")
                .antMatchers("/fonts.googleapis.com/**", "/.i.pravatar.cc", "/maxcdn.bootstrapcdn.com/**", "/health");

        // necessary for the thymeleaf-extra-security4 to function properly and allow to use method sec:authorize="hasPermission(...)" in html view
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        //handler.setPermissionEvaluator(customPermissionEvaluator);
        webSecurity.expressionHandler(handler);
        /*Enable spring security debugging: allowed only in development enviroment only*/
//        websecurity.debug(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .authorizeRequests()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/api/**",
                        "/forgot-password/**",
                        "/phone-verification-code/**",
                        "/users/resend-verification-email/**",
                        "/users/change-email/**",
                        "/users/phone/**",
                        "/profile/email-change/",
                        "/users/resend-phone-verification-code/**",
                        "/confirm-registration/**",
                        "/resend-registration-token**",
                        "/password-reset/**", "/_error/**", "/resources/static/**").permitAll()
                .antMatchers("/resetpassword/*", "/first-time/**", "/activate/**").permitAll()
                .antMatchers("/setup-account/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successHandler(loginSuccessfulHandler()).failureHandler(loginFailureHandler())
                .usernameParameter("email").passwordParameter("password").permitAll()
//                .and().exceptionHandling().accessDeniedHandler()
            //  .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint())  //used for users not authenticated, we can return 403 when on ajax  requests
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .addLogoutHandler(customLogoutHandler)
                .permitAll().and()
                .exceptionHandling()
                .accessDeniedPage("/_error/403")
                .and()
                .csrf().and()
                .sessionManagement()
                .invalidSessionUrl("/login")
                /*Concurrent session control*/
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false)
                /*Session timeout management*/
                .expiredUrl("/login?expired");

    }





    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint(){
        return new  CustomAuthenticationEntryPoint();
    }

    @Bean
    LoginFailureHandler loginFailureHandler(){
        return new LoginFailureHandler();
    }

    @Bean
    LoginSuccessfulHandler loginSuccessfulHandler(){
        return  new LoginSuccessfulHandler();
    }
    @Bean
    public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
    }
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
}
