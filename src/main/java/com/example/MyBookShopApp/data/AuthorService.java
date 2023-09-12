package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Authors> getAuthorsData(){
        List<Authors> authors = jdbcTemplate.query("SELECT * FROM authors",(ResultSet rs, int rowNum)->{
            Authors author = new Authors();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
            author.setOld(rs.getInt("old"));

            return author;
        });
        return new ArrayList<>(authors);
    }
}
