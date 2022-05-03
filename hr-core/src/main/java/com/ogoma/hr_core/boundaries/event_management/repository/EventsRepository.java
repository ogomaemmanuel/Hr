package com.ogoma.vue_starter.vue_starter.boundaries.event_management.repository;

import com.ogoma.vue_starter.vue_starter.boundaries.event_management.entities.Event;
import com.ogoma.vue_starter.vue_starter.boundaries.performance.promotion.repository.BaseRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends BaseRepo<Event> {

}
