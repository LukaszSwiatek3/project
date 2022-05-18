package com.wevibe.project.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("")
    public List<Transaction> getAll() {
        return transactionRepository.getAll();
    }

    @GetMapping("/{id}")
    public Transaction getById(@PathVariable("id") Long id) {
        return transactionRepository.getTransactionById(id);
    }


    @PostMapping("")
    public int add(@RequestBody List<Transaction> transactions) {
        return transactionRepository.save(transactions);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Transaction updatedTransaction) {
        Transaction transaction = transactionRepository.getTransactionById(id);

        if (transaction != null) {
            transaction.setIdTickets(updatedTransaction.getIdTickets());
            transaction.setIdTicketBuyer(updatedTransaction.getIdTicketBuyer());
            transaction.setPurchaseDateTime(updatedTransaction.getPurchaseDateTime());
            transaction.setSummaryCost(updatedTransaction.getSummaryCost());

            transactionRepository.update(transaction);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody Transaction updatedTransaction) {
        Transaction transaction = transactionRepository.getTransactionById(id);

        if (transaction != null) {
            if (updatedTransaction.getIdTickets() != null) transaction.setIdTickets(updatedTransaction.getIdTickets());
            if (updatedTransaction.getIdTicketBuyer() != null) transaction.setIdTicketBuyer(updatedTransaction.getIdTicketBuyer());
            if (updatedTransaction.getPurchaseDateTime() != null) transaction.setPurchaseDateTime(updatedTransaction.getPurchaseDateTime());
            if (updatedTransaction.getSummaryCost() != null) transaction.setSummaryCost(updatedTransaction.getSummaryCost());

            transactionRepository.update(transaction);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return transactionRepository.delete(id);
    }

}
