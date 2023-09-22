package com.example.MyBookShopApp.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_file")
public class BookFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String hash;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String path;
    @Column(columnDefinition = "INT NOT NULL")
    private Integer typeId;
}
