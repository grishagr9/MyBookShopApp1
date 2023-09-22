package com.example.MyBookShopApp.data.repositories;

import com.example.MyBookShopApp.data.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {


    @Query("from Book")
    List<Book> customFindAllBooks();

}
