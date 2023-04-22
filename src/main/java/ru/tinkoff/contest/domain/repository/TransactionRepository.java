package ru.tinkoff.contest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.contest.domain.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}