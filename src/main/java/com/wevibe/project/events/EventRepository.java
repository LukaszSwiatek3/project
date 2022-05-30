package com.wevibe.project.events;

import com.wevibe.project.addresses.Address;
import com.wevibe.project.events.EventGeolocations.EventGeolocation;
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
        return jdbcTemplate.queryForObject("SELECT id_event, name_event, start_date_event, end_date_event, limit_of_participants, event_address, event_organisator, description, " +
                "addresses.name_address, addresses.city, addresses.country, addresses.postal_code, addresses.street, addresses.street_number, addresses.apartment_number  " +
                "FROM events " +
                "FULL JOIN addresses " +
                "ON event_address = addresses.id_address " +
                "WHERE " +
                "id_event = ?", BeanPropertyRowMapper.newInstance(Event.class), id);
    }

    public List<Event> getAllAddress(Long id) {
        return jdbcTemplate.query("SELECT id_event, name_event, start_date_event, end_date_event, limit_of_participants, event_address, event_organisator, description  " +
                        "FROM events WHERE " +
                        "event_address =?",
                BeanPropertyRowMapper.newInstance(Event.class), id);
    }

    public List<EventGeolocation> getAllNotNull() {
        return jdbcTemplate.query("events.id_event, events.name_event, events.start_date_event, events.end_date_event, events.limit_of_participants, events.event_address,  events.event_organisator, events.description, \n" +
                        "addresses.name_address, addresses.city, addresses.country, addresses.postal_code, addresses.street, addresses.street_number, addresses.apartment_number\n" +
                        "FROM events e\n" +
                        "JOIN addresses a ON e.event_address = a.id_address\n" +
                        "WHERE event_address is NOT NULL",
                BeanPropertyRowMapper.newInstance(EventGeolocation.class));
    }

    public List<Event> getAllForTag(Long id) {
        return jdbcTemplate.query("SELECT id_event, name_event, start_date_event, end_date_event, limit_of_participants, event_address, event_organisator, description\n" +
                "FROM events e\n" +
                "JOIN events_tags et ON e.id_event = et.event_id\n" +
                "JOIN tags t ON et.tag_id = t.id_tag\n" +
                "WHERE " + "id_tag = ? ", BeanPropertyRowMapper.newInstance(Event.class), id);
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
