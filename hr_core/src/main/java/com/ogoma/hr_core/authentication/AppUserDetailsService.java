package com.ogoma.hr_core.authentication;

import com.ogoma.hr_core.boundaries.access_control.entities.User;
import com.ogoma.hr_core.boundaries.access_control.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private  final UserService userService;

    public AppUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.getUserByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return new CustomUserDetails(user);

    }
}
