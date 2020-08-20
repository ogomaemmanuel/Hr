package com.ogoma.vue_starter.vue_starter.authentication;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.entities.User;
import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.getUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return new CustomUserDetails(user);


    }
}
