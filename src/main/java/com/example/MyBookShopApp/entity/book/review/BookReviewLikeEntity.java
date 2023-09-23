package com.example.MyBookShopApp.entity.book.review;

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
@Table(name = "book_review_like")
@Getter
@Setter
public class BookReviewLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "INT NOT NULL")
    private int reviewId;

    @Column(columnDefinition = "INT NOT NULL")
    private int userId;

   // @Column(columnDefinition = "TIMESTAMP NOT NULL")
    private LocalDateTime time;

    //@Column(columnDefinition = "SMALLINT NOT NULL")
    private short value;


}
