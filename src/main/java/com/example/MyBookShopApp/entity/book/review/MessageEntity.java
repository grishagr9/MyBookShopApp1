package com.example.MyBookShopApp.entity.book.review;

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
@Table(name = "message")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //@Column(columnDefinition = "TIMESTAMP NOT NULL")
    LocalDateTime time;

    @Column(columnDefinition = "INT")
    int userId;

    @Column(columnDefinition = "VARCHAR(255)")
    String email;

    @Column(columnDefinition = "VARCHAR(255)")
    String name;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String subject;

    //@Column(columnDefinition = "TEXT NOT NULL")
    String text;
}
