package com.ogoma.vue_starter.vue_starter.boundaries.notifications.services;

import com.ogoma.vue_starter.vue_starter.boundaries.notifications.entities.Notification;
import com.ogoma.vue_starter.vue_starter.boundaries.notifications.repositories.NotificationsRepository;
import org.springframework.stereotype.Component;

@Component
public class NotificationsService {
    private final NotificationsRepository notificationsRepository;

    public NotificationsService(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    public void createNotification(Notification notification) {
        this.notificationsRepository.save(notification);
    }
}
