package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.repositories.AuthorRepository;
import com.example.MyBookShopApp.entity.Authors;
import com.example.MyBookShopApp.repositories.BookRepository;
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
    private final BookRepository bookRepository;

    public Authors getAuthorByName(String name){
        return authorRepository.findByName(name);
    }

    public Map<String, List<Authors>> getAuthorsMap() {
        List<Authors> authors = authorRepository.findAll();
        return authors.stream().collect(Collectors.groupingBy((Authors a) -> a.getName().substring(0, 1)));
    }

    public List<Book> getBookByAuthor(String nameAuthor) {
        Authors author = getAuthorByName(nameAuthor);
        return bookRepository.findBooksByAuthor(author);
    }
}
