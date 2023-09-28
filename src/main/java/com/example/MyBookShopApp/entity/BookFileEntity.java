package com.example.MyBookShopApp.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Table(name = "book_file")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class BookFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String hash;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String path;
    @Column(columnDefinition = "INT NOT NULL")
    Integer typeId;
}
