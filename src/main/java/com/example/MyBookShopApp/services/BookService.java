package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.repositories.BookRepository;
import com.example.MyBookShopApp.entity.Book;
import io.swagger.v3.core.util.AnnotationsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfNewsBooks(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findBooksByTitleContaining(searchWord, nextPage);
    }

    public Page<Book> getPageOfRecentBooksResult(Integer offset, Integer limit, Date fromDate, Date toDate){
        Pageable nextPage = PageRequest.of(offset, limit);
        //return bookRepository.findAllByOrderByPubDateDesc(nextPage);
       //return bookRepository.findAllByPubDateBetweenAndOrderByPubDateDesc(fromDate, toDate, nextPage);
        return bookRepository.findAllByPubDateBetween(fromDate,toDate,nextPage);
    }

}
