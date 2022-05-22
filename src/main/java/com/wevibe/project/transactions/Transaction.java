package com.wevibe.project.transactions;

import com.wevibe.project.tickets.Ticket;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    private Long idTransaction;

    @OneToMany(mappedBy = "transaction")
    private List<Ticket> tickets;
    @Column(name = "id_ticket_buyer", nullable = false, length = 20)
    private Long idTicketBuyer;
    @Column(name = "purchase_date_time", nullable = false, length = 45)
    private String purchaseDateTime;
    @Column(name = "summary_cost", nullable = false)
    private Double summaryCost;

    public Transaction() {

    }

    public Transaction(Long idTransaction, List<Ticket> tickets, Long idTicketBuyer, String purchaseDateTime, Double summaryCost) {
        this.idTransaction = idTransaction;
        this.tickets = tickets;
        this.idTicketBuyer = idTicketBuyer;
        this.purchaseDateTime = purchaseDateTime;
        this.summaryCost = summaryCost;
    }

    public Transaction(List<Ticket> tickets, Long idTicketBuyer, String purchaseDateTime, Double summaryCost) {
        this.tickets = tickets;
        this.idTicketBuyer = idTicketBuyer;
        this.purchaseDateTime = purchaseDateTime;
        this.summaryCost = summaryCost;
    }

    public Long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(Long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Long getIdTicketBuyer() {
        return idTicketBuyer;
    }

    public void setIdTicketBuyer(Long idTicketBuyer) {
        this.idTicketBuyer = idTicketBuyer;
    }

    public String getPurchaseDateTime() {
        return purchaseDateTime;
    }

    public void setPurchaseDateTime(String purchaseDateTime) {
        this.purchaseDateTime = purchaseDateTime;
    }

    public Double getSummaryCost() {
        return summaryCost;
    }

    public void setSummaryCost(Double summaryCost) {
        this.summaryCost = summaryCost;
    }
}