package es.upm.miw.trust_tie_backend.api.resources;

import es.upm.miw.trust_tie_backend.model.dtos.EventDto;
import es.upm.miw.trust_tie_backend.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EventResource.EVENTS)
@RequiredArgsConstructor
public class EventResource {

    public static final String EVENTS = "/events";
    public static final String EVENT_ID = "/{eventId}";

    private final EventService eventService;

    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping(EVENT_ID)
    public EventDto getEvent(@PathVariable String eventId) {
        return eventService.getEvent(eventId);
    }

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto eventDto, @RequestHeader("Authorization") String authorization) {
        return eventService.createEvent(eventDto, authorization);
    }

    @PutMapping(EVENT_ID)
    public EventDto updateEvent(@PathVariable String eventId, @RequestBody EventDto eventDto, @RequestHeader("Authorization") String authorization) {
        return eventService.updateEvent(eventId, eventDto, authorization);
    }

    @DeleteMapping(EVENT_ID)
    public void deleteEvent(@PathVariable String eventId, @RequestHeader("Authorization") String authorization) {
        eventService.deleteEvent(eventId, authorization);
    }
}