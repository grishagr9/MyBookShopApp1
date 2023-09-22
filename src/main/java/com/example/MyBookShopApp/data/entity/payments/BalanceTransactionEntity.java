package com.example.MyBookShopApp.data.entity.payments;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "balance_transaction")
@Getter
@Setter
public class BalanceTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "INT NOT NULL")
    private int userId;

    private LocalDateTime time;

    @Column(columnDefinition = "INT NOT NULL DEFAULT 0")
    private int value;

    @Column(columnDefinition = "INT NOT NULL")
    private int bookId;


    private String description;
}
