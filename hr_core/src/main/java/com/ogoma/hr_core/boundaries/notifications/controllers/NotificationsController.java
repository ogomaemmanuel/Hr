package com.ogoma.hr_core.boundaries.notifications.controllers;

import com.ogoma.hr_core.authentication.CustomUserDetails;
import com.ogoma.hr_core.boundaries.notifications.entities.Notification;
import com.ogoma.hr_core.boundaries.notifications.services.NotificationsService;
import com.ogoma.hr_core.models.requests.PagedDataRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class NotificationsController {

    private final NotificationsService notificationsService;

    public NotificationsController(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @RequestMapping("api/user-notifications")
    public ResponseEntity<?> getUserNotification(PagedDataRequest pagedDataRequest) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Page<Notification> notifications =
                this.notificationsService.findNotificationByUserId(customUserDetails.getId(), pagedDataRequest);
        return ResponseEntity.ok(notifications);
    }
}
