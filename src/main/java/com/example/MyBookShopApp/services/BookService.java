package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.repositories.BookRepository;
import com.example.MyBookShopApp.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    //new book service methods

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<Book> getBooksWithPriceBetween(Integer min, Integer max){
        return bookRepository.findBooksByPriceBetween(min,max);
    }

    public List<Book> getBooksWithPrice(Integer price){
        return bookRepository.findBooksByPriceIs(price);
    }

    public List<Book> getBooksWithMaxDiscount(){
        return bookRepository.getBooksWithMaxDiscount();
    }

    public List<Book> getBestSellers(){
        return bookRepository.getBestsellers();
    }

}
