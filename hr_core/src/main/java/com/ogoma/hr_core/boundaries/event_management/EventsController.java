package com.ogoma.hr_core.boundaries.event_management;

import com.ogoma.hr_core.boundaries.event_management.entities.Event;
import com.ogoma.hr_core.boundaries.event_management.requests.EventCreateRequest;
import com.ogoma.hr_core.boundaries.event_management.services.EventsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "api/events")
public class EventsController {
    private final EventsService eventsService;

    public EventsController(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping
    public ResponseEntity<?> getEvents() {
        List<Event> events =
                this.eventsService.getEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getEventById(@PathVariable Long id) {
        Optional<Event> event = this.eventsService.getEventById(id);
        return ResponseEntity.of(event);
    }

    @PostMapping
    public ResponseEntity<?> createEvent(@RequestBody @Valid EventCreateRequest eventCreateRequest) {
        Event event = this.eventsService.createEvent(eventCreateRequest);
        return ResponseEntity.ok(event);
    }
    @PutMapping(value = "/{id}")
    public  ResponseEntity<?> updateEvent(@PathVariable Long id,@RequestBody @Valid EventCreateRequest eventCreateRequest){
        Optional<Event> event = this.eventsService.updateEvent(id,eventCreateRequest);
        return ResponseEntity.of(event);
    }

}
