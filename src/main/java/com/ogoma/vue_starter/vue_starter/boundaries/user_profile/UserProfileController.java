package com.ogoma.vue_starter.vue_starter.boundaries.user_profile;

import com.ogoma.vue_starter.vue_starter.boundaries.access_control.services.UserService;
import com.ogoma.vue_starter.vue_starter.boundaries.user_profile.models.PasswordUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserProfileController {
    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/profile/update-password",method = RequestMethod.POST)
    public ResponseEntity<?> updatePassword(@RequestBody PasswordUpdateRequest passwordUpdateRequest) {
      this.userService.updatePassword(passwordUpdateRequest);
      return ResponseEntity.ok("Password successfully updated");
    }
}
