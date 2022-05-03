package com.ogoma.hr_core.boundaries.event_management.services;

import com.ogoma.hr_core.boundaries.event_management.entities.Event;
import com.ogoma.hr_core.boundaries.event_management.repository.EventsRepository;
import com.ogoma.hr_core.boundaries.event_management.requests.EventCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsService {
    private final EventsRepository eventsRepository;

    public EventsService(EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public Event createEvent(EventCreateRequest eventCreateRequest) {
        Event event = new Event();
        convertToEntity(event, eventCreateRequest);
        this.eventsRepository.save(event);
        return event;
    }

    public List<Event> getEvents() {
        return this.eventsRepository.findAll();
    }


    public Optional<Event> getEventById(Long id) {
        Optional<Event> event = this.eventsRepository.findById(id);
        return event;
    }

    public Optional<Event> updateEvent(Long id, EventCreateRequest eventCreateRequest) {
        Optional<Event> event = this.eventsRepository.findById(id);
        event.ifPresent(ev -> {
            convertToEntity(ev, eventCreateRequest);
        });
        return event;
    }

    private void convertToEntity(Event event, EventCreateRequest eventCreateRequest) {
        event.setDescription(eventCreateRequest.getDescription());
        event.setVenue(eventCreateRequest.getVenue());
        event.setStartDate(eventCreateRequest.getStartDate());
        event.setName(eventCreateRequest.getName());
        event.setStartTime(eventCreateRequest.getStartTime());
        event.setEndDate(eventCreateRequest.getEndDate());
    }
}
