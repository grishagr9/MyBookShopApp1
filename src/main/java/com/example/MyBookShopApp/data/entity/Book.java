package com.example.MyBookShopApp.data.entity;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "books")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(Integer isBestseller) {
        this.isBestseller = isBestseller;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    /* @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Authors author;
    private String title;
    @Column(name = "price_old")
    private String priceOld;
    private String price;*/


}
