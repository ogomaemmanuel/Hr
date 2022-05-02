package com.ogoma.vue_starter.vue_starter.boundaries.company.repositories;

import com.ogoma.vue_starter.vue_starter.boundaries.company.entities.EmailSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailSettingRepository extends JpaRepository<EmailSetting,Long> {

}
