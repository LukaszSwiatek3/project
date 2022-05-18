package com.wevibe.project.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("")
    public List<Ticket> getAll() {return ticketRepository.getAll();}

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable("id") Long id) {
        return ticketRepository.getTicketById(id);
    }

    @PostMapping("")
    public int add(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Ticket updatedTicket) {
        Ticket ticket = ticketRepository.getTicketById(id);

        if (ticket != null) {
            ticket.setIdEvent(updatedTicket.getIdEvent());
            ticket.setUuidCode(updatedTicket.getUuidCode());
            ticket.setPrice(updatedTicket.getPrice());

            ticketRepository.update(ticket);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody Ticket updatedTicket) {
        Ticket ticket = ticketRepository.getTicketById(id);

        if (ticket != null) {
            if (updatedTicket.getIdEvent() != null) ticket.setIdEvent(updatedTicket.getIdEvent());
            if (updatedTicket.getUuidCode() != null) ticket.setUuidCode(updatedTicket.getUuidCode());
            if (updatedTicket.getPrice() != null) ticket.setPrice(updatedTicket.getPrice());

            ticketRepository.update(ticket);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return ticketRepository.delete(id);
    }

}
