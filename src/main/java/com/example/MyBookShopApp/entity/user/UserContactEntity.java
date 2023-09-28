package com.example.MyBookShopApp.entity.user;

import com.example.MyBookShopApp.entity.enums.ContactType;

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
@Table(name = "user_contact")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class UserContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(columnDefinition = "INT NOT NULL")
    int userId;

    ContactType type;

    @Column(columnDefinition = "SMALLINT NOT NULL")
    short approved;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String code;

    @Column(columnDefinition = "INT")
    int codeTrails;

    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime codeTime;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String contact;
}
