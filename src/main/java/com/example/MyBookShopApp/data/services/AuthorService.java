package com.example.MyBookShopApp.data.services;

import com.example.MyBookShopApp.data.repositories.AuthorRepository;
import com.example.MyBookShopApp.data.entity.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<String, List<Authors>> getAuthorsMap() {
        List<Authors> authors = authorRepository.findAll();
        return authors.stream().collect(Collectors.groupingBy((Authors a)->{return a.getName().substring(0,1);}));
    }
}
