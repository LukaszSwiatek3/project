package com.wevibe.project.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TransactionRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Transaction> getAll() {
        return jdbcTemplate.query("SELECT id_transaction, id_ticket_buyer, id_tickets, purchase_date_time, summary_cost FROM transactions",
                BeanPropertyRowMapper.newInstance(Transaction.class));
    }

    public Transaction getTransactionById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_ticket_buyer, id_tickets, purchase_date_time, summary_cost FROM transactions WHERE " +
                "id_transaction = ?", BeanPropertyRowMapper.newInstance(Transaction.class), id);
    }

    public int save(List<Transaction> transactions) {
        transactions.forEach(transaction -> jdbcTemplate
                .update("INSERT INTO transactions(id_ticket_buyer, id_tickets, purchase_date_time, summary_cost) VALUES(?, ?, ?, ?)",
                        transaction.getIdTicketBuyer(), transaction.getTickets(), transaction.getPurchaseDateTime(), transaction.getSummaryCost()
                ));

        return 1;
    }

    public int update(Transaction transaction) {
        return jdbcTemplate.update("UPDATE transactions SET id_ticket_buyer=?, id_tickets=?, purchase_date_time=?, summary_cost=? WHERE id_transaction=?",
                transaction.getIdTicketBuyer(), transaction.getTickets(), transaction.getPurchaseDateTime(), transaction.getSummaryCost(), transaction.getIdTransaction());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM transactions WHERE id_transaction=?", id);
    }

}
