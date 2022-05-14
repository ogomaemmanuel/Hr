package com.ogoma.hr_core.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.ogoma.hr_core.boundaries.access_control.entities.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private Long id;
    private String fullName;
    private String phone;
    private Date joiningDate;
    private User user;
    private User.UserType userType;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    public Long getId() {
        return this.user.getId();
    }


    public String getFullName() {
        return this.user.getFullName();
    }

    public Date getJoiningDate() {
        return this.user.getCreatedOn();
    }

    public String getPhone() {
        return this.user.getPhone();
    }

    public User.UserType getUserType() {
        return this.user.getUserType();
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userDetailsJson = objectMapper.writeValueAsString(this);
        return userDetailsJson;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // user.getUserRoles().stream().findFirst().orElse(new Role());
        List<GrantedAuthority> authorities = new ArrayList<>();
        //  for (String privilege : privileges) {
        authorities.add(new SimpleGrantedAuthority("ADMIN"));
        // }
        //return new ArrayList<GrantedAuthority>();
        return authorities;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

//    @JsonIgnore
//    public Employee getEmployee() {
//        return this.user.getEmployee();
//    }

    @JsonIgnore
    public User getUser() {
        return this.user;
    }
}
