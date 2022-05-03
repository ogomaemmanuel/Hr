package com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays;

import com.ogoma.vue_starter.vue_starter.boundaries.hr.holidays.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends JpaRepository<Holiday,Long> {
}
