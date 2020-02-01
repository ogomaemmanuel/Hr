package com.ogoma.vue_starter.vue_starter.authentication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {
    private Long id;
    private String fullName;
    private String phone;

    public CustomUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                             boolean credentialsNonExpired, boolean accountNonLocked,
                             Collection<? extends GrantedAuthority> authorities, Long id, String fullName, String phone) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }


    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String userDetailsJson = objectMapper.writeValueAsString(this);
        return userDetailsJson;
    }
}
