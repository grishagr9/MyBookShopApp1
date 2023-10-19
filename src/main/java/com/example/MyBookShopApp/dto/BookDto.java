package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entity.Authors;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookDto {

    private String title;

    private Authors author;

    private Integer price;

    private String description;

    private Double discount;

    Integer isBestseller;

    String image;

    Date pubDate;

    String slug;

    private Integer count_of_buyers;

    private Integer count_of_cart;

    private Integer count_of_delay;

    public Long getRoundDiscount(){
        return Math.round(discount);
    }

    public Long getNewPrice(){
        return Math.round(price * (1 - discount/100));
    }

}
