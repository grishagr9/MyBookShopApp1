package com.example.MyBookShopApp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Book() {
    }
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String text;
    @Column(columnDefinition = "INT")
    private Integer discount;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String image;
    @Column(columnDefinition = "INT")
    private Integer isBestseller;
   // @Column(columnDefinition = "integer")
    private Integer price;
   // @Column(columnDefinition = "DATE NOT NULL")
    private Date pubDate;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String slug;
    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String title;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", discount=" + discount +
                ", image='" + image + '\'' +
                ", isBestseller=" + isBestseller +
                ", price=" + price +
                ", pubDate=" + pubDate +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
