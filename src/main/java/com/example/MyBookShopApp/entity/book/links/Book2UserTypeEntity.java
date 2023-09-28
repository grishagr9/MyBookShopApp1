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


@Getter
@Setter
@Table(name = "book2user_type")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class Book2UserTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String code;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String name;
}
