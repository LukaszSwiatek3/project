package com.wevibe.project.ticket;

import javax.persistence.*;
import java.util.UUID;
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long idTicket;
    @Column(name = "id_event", nullable = false, length = 20)
    private Long idEvent;
    @Column(name = "uuid_code", nullable = false, length = 20)
    private UUID uuidCode;
    @Column(name = "price", nullable = false)
    private Double price;

    public Ticket() {

    }

    public Ticket(Long idTicket, Long idEvent, UUID uuidCode, Double price) {
        this.idTicket = idTicket;
        this.idEvent = idEvent;
        this.uuidCode = uuidCode;
        this.price = price;
    }

    public Ticket(Long idEvent, UUID uuidCode, Double price) {
        this.idEvent = idEvent;
        this.uuidCode = uuidCode;
        this.price = price;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public UUID getUuidCode() {
        return uuidCode;
    }

    public void setUuidCode(UUID uuidCode) {
        this.uuidCode = uuidCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
