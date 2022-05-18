package com.wevibe.project.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Ticket> getAll() {
        return jdbcTemplate.query("SELECT id_ticket, id_event, price, uuid_code FROM tickets",
                BeanPropertyRowMapper.newInstance(Ticket.class));
    }

    public Ticket getTicketById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_ticket, id_event, price, uuid_code FROM tickets WHERE " +
                "id_ticket = ?", BeanPropertyRowMapper.newInstance(Ticket.class), id);
    }

    public int save(Ticket ticket) {
        jdbcTemplate.update("INSERT INTO tickets(id_event, uuid_code, price) VALUES(?, ?, ?)",
                        ticket.getIdEvent(), ticket.getUuidCode(), ticket.getPrice()
                );

        return 1;
    }

    public int update(Ticket ticket) {
        return jdbcTemplate.update("UPDATE tickets SET id_event=?, uuid_code=?, price=? WHERE id_ticket=?",
                ticket.getIdEvent(), ticket.getUuidCode(), ticket.getPrice(), ticket.getIdTicket());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM tickets WHERE id_ticket=?", id);
    }

}
