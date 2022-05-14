package com.ogoma.hr_core.boundaries.company.repositories;

import com.ogoma.hr_core.boundaries.company.entities.EmailSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSettingRepository extends JpaRepository<EmailSetting,Long> {

}
