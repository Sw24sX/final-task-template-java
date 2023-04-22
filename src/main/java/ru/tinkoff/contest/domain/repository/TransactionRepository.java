package ru.tinkoff.contest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.contest.domain.entity.Account;
import ru.tinkoff.contest.domain.entity.Transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select t from Transaction t where t.target = :target " +
            "and (cast(:fromDate as date) is null or t.dateTime >= :fromDate) " +
            "and (cast(:toDate as date) is null or t.dateTime <= :toDate)")
    List<Transaction> findAllByTargetAndRegionDate(Account target, LocalDateTime fromDate, LocalDateTime toDate);
}