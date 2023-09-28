package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.repositories.AuthorRepository;
import com.example.MyBookShopApp.entity.Authors;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Map<String, List<Authors>> getAuthorsMap() {
        List<Authors> authors = authorRepository.findAll();
        return authors.stream().collect(Collectors.groupingBy((Authors a) -> a.getName().substring(0, 1)));
    }
}
