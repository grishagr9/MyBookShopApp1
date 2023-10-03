package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.repositories.BookRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BooksRatingAndPopulatityService {

    private final BookRepository bookRepository;

    public Double getPopularity(Book book){
        return book.getCount_of_buyers() + 0.7 * book.getCount_of_cart() + 0.4 * book.getCount_of_delay();
    }

    public List<Book> getBookByPopularity(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset, limit);
        //из-за findAll(nextPage).getContent() мы получаем первые 5 книг базы данных, и уже для них
        //ищем самую популярную - что неправильно.
        //List<Book> books = bookRepository.findAll(nextPage).getContent();
        List<Book> books = bookRepository.findAll();
        TreeMap<Double,Book> map = new TreeMap<>();
        //new TreeMap<>(books.stream().collect(Collectors.groupingBy(this::getPopularity)));
        for (Book book : books) {
            map.put(getPopularity(book), book);
        }
        var a = new ArrayList<>(map.values());
        Collections.reverse(a);
        return getRange(a, offset*limit,offset*limit+limit);
    }

    private List<Book> getRange(List<Book> books, Integer start, Integer end){
        List<Book> res  = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            res.add(books.get(i));
        }
        return res;
    }
}

