package com.wevibe.project.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventService {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    ObjectMapper objectMapper;


}
