package com.wevibe.project.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    EventRepository eventRepository;

//    @Autowired
//    ObjectMapper objectMapper;

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
