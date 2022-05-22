package com.wevibe.project.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @GetMapping("")
    public List<Event> getAll() {
        return eventRepository.getAll();
    }

    @GetMapping("/{id}")
    public Event getById(@PathVariable("id") Long id) {
        return eventRepository.getEventById(id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Event> events) {
        return eventRepository.save(events);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Event updatedEvent) {
        Event event = eventRepository.getEventById(id);

        if (event != null) {
            event.setNameEvent(updatedEvent.getNameEvent());
            event.setStartDateEvent(updatedEvent.getStartDateEvent());
            event.setEndDateEvent(updatedEvent.getEndDateEvent());
            event.setLimitOfParticipants(updatedEvent.getLimitOfParticipants());
            event.setEventAddress(updatedEvent.getEventAddress());
            event.setOrganisator(updatedEvent.getOrganisator());
            event.setDescription(updatedEvent.getDescription());

            eventRepository.update(event);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody Event updatedEvent) {
        Event event = eventRepository.getEventById(id);

        if (event != null) {
            if (updatedEvent.getNameEvent() != null) event.setNameEvent(updatedEvent.getNameEvent());
            if (updatedEvent.getStartDateEvent() != null) event.setStartDateEvent(updatedEvent.getStartDateEvent());
            if (updatedEvent.getEndDateEvent() != null) event.setEndDateEvent(updatedEvent.getEndDateEvent());
            if (updatedEvent.getLimitOfParticipants() != null)
                event.setLimitOfParticipants(updatedEvent.getLimitOfParticipants());
            if (updatedEvent.getEventAddress() != null) event.setEventAddress(updatedEvent.getEventAddress());
            if (updatedEvent.getOrganisator() != null) event.setOrganisator(updatedEvent.getOrganisator());
            if (updatedEvent.getDescription() != null) event.setDescription(updatedEvent.getDescription());

            eventRepository.update(event);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return eventRepository.delete(id);
    }


}
