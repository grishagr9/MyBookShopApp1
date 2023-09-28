package com.example.MyBookShopApp.entity.other;

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
@Table(name = "document")
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@Entity
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(columnDefinition = "INT NOT NULL  DEFAULT 0")
    int sortIndex;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String slug;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    String title;

   // @Column(columnDefinition = "TEXT NOT NULL")
    String text;
}
