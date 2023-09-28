package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.repositories.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BooksRatingAndPopulatityService {

    private BookRepository bookRepository;

    public Double getPopularity(Book book){
        return 1.0;
        //book.getCountOfBuyers() + 0.7 * book.getCountOfCart() + 0.4 * book.getCountOfDelay();
    }

    public Map<Double,List<Book>> getBookByPopularity(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        List<Book> books = bookRepository.findAll();
        return books.stream().collect(Collectors.groupingBy(this::getPopularity));
    }
}

