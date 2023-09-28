package com.example.MyBookShopApp.entity.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String hash;

    //@Column(columnDefinition = "TIMESTAMP NOT NULL")
    LocalDateTime regTime;

    @Column(columnDefinition = "INT NOT NULL  DEFAULT 0")
    int balance;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String name;

}
