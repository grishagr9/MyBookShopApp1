package com.example.MyBookShopApp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
public class DateRecentDto {
    private Date date;

    public DateRecentDto(Date date) {
        this.date = date;
    }
}
