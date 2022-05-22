package com.wevibe.project.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Event> getAll() {
        return jdbcTemplate.query("SELECT id_event, name_event, start_date_event, end_date_event, limit_of_participants, event_address, event_organisator, description  FROM events",
                BeanPropertyRowMapper.newInstance(Event.class));
    }

    public Event getEventById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_event, name_event, start_date_event, end_date_event, limit_of_participants, event_address, event_organisator, description FROM events WHERE " +
                "id_event = ?", BeanPropertyRowMapper.newInstance(Event.class), id);
    }

    public int save(List<Event> events) {
        events.forEach(event -> jdbcTemplate
                .update("INSERT INTO events(name_event, start_date_event, end_date_event, limit_of_participants, event_address, event_organisator, description) VALUES(?, ?, ?, ?, ?, ?, ?)",
                        event.getNameEvent(), event.getStartDateEvent(), event.getEndDateEvent(), event.getLimitOfParticipants(), event.getEventAddress(), event.getOrganisator(), event.getDescription()
                ));

        return 1;
    }

    public int update(Event event) {
        return jdbcTemplate.update("UPDATE events SET name_event=?, start_date_event=?, end_date_event=?, limit_of_participants=?, event_address=?, event_organisator=?, description=? WHERE id_event=?",
                event.getNameEvent(), event.getStartDateEvent(), event.getEndDateEvent(), event.getLimitOfParticipants(), event.getEventAddress(), event.getOrganisator(), event.getDescription(), event.getIdEvent());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM events WHERE id_event=?", id);
    }

}
