package com.ogoma.hr_core.boundaries.hr.holidays;

import com.ogoma.hr_core.boundaries.hr.holidays.entities.Holiday;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends BaseRepo<Holiday> {
}
