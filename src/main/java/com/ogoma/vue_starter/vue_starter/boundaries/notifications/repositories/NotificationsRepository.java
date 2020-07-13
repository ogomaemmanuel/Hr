package com.ogoma.vue_starter.vue_starter.boundaries.notifications.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.notifications.entities.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends JpaRepository<Notification, Long> {
    Page<Notification> findAllByUserId(Long userId,Pageable pageable);
}
