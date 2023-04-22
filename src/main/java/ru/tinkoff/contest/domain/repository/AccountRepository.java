package ru.tinkoff.contest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.contest.domain.entity.Account;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    @Query("select a from Account a where a.id = ?1")
    Optional<Account> findByIdPessimisticLock(Integer id);
}