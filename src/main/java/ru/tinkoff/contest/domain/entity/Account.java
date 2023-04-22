package ru.tinkoff.contest.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    @Version
    @Column(nullable = false)
    private long version;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDate birthDay;

    @Column(nullable = false)
    private String currency;

    @Column(nullable = false)
    private Double amount;
}
