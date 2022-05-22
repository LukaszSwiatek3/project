package com.wevibe.project.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepositoryInterface extends JpaRepository<Transaction, Long> {
}
