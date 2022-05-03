package com.ogoma.hr_core.boundaries.event_management.repository;

import com.ogoma.hr_core.boundaries.event_management.entities.Event;
import com.ogoma.hr_core.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends BaseRepo<Event> {

}
