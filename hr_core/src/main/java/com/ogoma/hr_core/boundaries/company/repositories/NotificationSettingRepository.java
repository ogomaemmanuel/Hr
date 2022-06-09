package com.ogoma.hr_core.boundaries.company.repositories;

import com.ogoma.hr_core.boundaries.company.entities.NotificationSetting;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationSettingRepository extends BaseRepo<NotificationSetting> {

}
