package com.example.MyBookShopApp.dto;

import java.util.Date;

public class DateRecentDto {
    private Date date;

    public DateRecentDto(Date dateRecent) {
        this.date = dateRecent;
    }

    public DateRecentDto() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date dateRecent) {
        this.date = dateRecent;
    }
}
