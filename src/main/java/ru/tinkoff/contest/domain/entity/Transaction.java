package ru.tinkoff.contest.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Account target;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private Double amount;
}
