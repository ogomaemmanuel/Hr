package com.ogoma.hr_core.boundaries.hr.holidays;

import com.ogoma.hr_core.boundaries.hr.holidays.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends JpaRepository<Holiday,Long> {
}
