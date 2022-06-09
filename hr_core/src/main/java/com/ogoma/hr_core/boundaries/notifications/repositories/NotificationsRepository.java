package com.ogoma.hr_core.boundaries.notifications.repositories;

import com.ogoma.hr_core.boundaries.notifications.entities.Notification;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationsRepository extends BaseRepo<Notification> {
    Page<Notification> findAllByUserId(Long userId,Pageable pageable);
}
