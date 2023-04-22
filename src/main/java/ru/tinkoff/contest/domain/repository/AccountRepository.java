package ru.tinkoff.contest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tinkoff.contest.domain.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}