package com.example.MyBookShopApp.entity.book.links;

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
@Table(name = "book2user")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class Book2UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //@Column(columnDefinition = "TIMESTAMP NOT NULL")
    LocalDateTime time;

    @Column(columnDefinition = "INT NOT NULL")
    int typeId;

    @Column(columnDefinition = "INT NOT NULL")
    int bookId;

    @Column(columnDefinition = "INT NOT NULL")
    int userId;
}
