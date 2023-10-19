package com.example.MyBookShopApp.dto;

import com.example.MyBookShopApp.entity.Book;

import java.util.List;

public class BooksPageDto {
    private Integer count;
    private List<BookDto> books;

    public BooksPageDto(List<BookDto> books) {
        this.count = books.size();
        this.books = books;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }
}
