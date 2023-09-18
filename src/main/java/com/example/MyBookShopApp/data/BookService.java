package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books",(ResultSet rs, int rowNum)->{
           Book book = new Book();
           book.setId(rs.getInt("id"));
           book.setAuthor(getAuthorById(rs.getInt("author_id")));
           book.setTitle(rs.getString("title"));
           book.setPriceOld(rs.getString("price_old"));
           book.setPrice(rs.getString("price"));
           return book;
        });

        return new ArrayList<>(books);
    }

    private String getAuthorById(int author_id) {
        List<Authors> authors = jdbcTemplate.query("SELECT * FROM authors WHERE authors.id=" + author_id,(ResultSet rs, int rowNum)->
        {
           Authors authors1 = new Authors();
           authors1.setId(rs.getInt("id"));
           authors1.setFirstName(rs.getString("first_name"));
           authors1.setLastName(rs.getString("last_name"));
           return authors1;
        });
        return authors.get(0).toString();
    }
}
