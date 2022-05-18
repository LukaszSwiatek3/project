package com.wevibe.project.transactions;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaction")
    private Long idTransaction;
    @Column(name = "id_tickets", nullable = false, length = 20)
    private Long idTickets;
    @Column(name = "id_ticket_buyer", nullable = false, length = 20)
    private Long idTicketBuyer;
    @Column(name = "purchase_date_time", nullable = false, length = 45)
    private String purchaseDateTime;
    @Column(name = "summary_cost", nullable = false)
    private Double summaryCost;

    public Transaction() {

    }

    public Transaction(Long idTransaction, Long idTickets, Long idTicketBuyer, String purchaseDateTime, Double summaryCost) {
        this.idTransaction = idTransaction;
        this.idTickets = idTickets;
        this.idTicketBuyer = idTicketBuyer;
        this.purchaseDateTime = purchaseDateTime;
        this.summaryCost = summaryCost;
    }

    public Transaction(Long idTickets, Long idTicketBuyer, String purchaseDateTime, Double summaryCost) {
        this.idTickets = idTickets;
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

    public Long getIdTickets() {
        return idTickets;
    }

    public void setIdTickets(Long idTickets) {
        this.idTickets = idTickets;
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