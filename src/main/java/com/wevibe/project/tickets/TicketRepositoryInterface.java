package com.wevibe.project.tickets;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepositoryInterface extends JpaRepository<Ticket, Long> {
}
