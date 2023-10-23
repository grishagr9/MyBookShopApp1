package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.BookDto;
import com.example.MyBookShopApp.mappers.BookMapper;
import com.example.MyBookShopApp.repositories.BookRepository;
import com.example.MyBookShopApp.entity.Book;
import io.swagger.v3.core.util.AnnotationsUtils;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    //new book service methods

    public List<BookDto> getBooksByTitle(String title) {
        return toDtos(bookRepository.findBooksByTitleContaining(title));
    }

    public List<BookDto> getBooksWithPriceBetween(Integer min, Integer max) {
        return toDtos(bookRepository.findBooksByPriceBetween(min, max));
    }

    public List<BookDto> getBooksWithPrice(Integer price) {
        return toDtos(bookRepository.findBooksByPriceIs(price));
    }

    public List<BookDto> getBooksWithMaxDiscount() {
        return toDtos(bookRepository.getBooksWithMaxDiscount());
    }

    public List<BookDto> getBestSellers() {
        return toDtos(bookRepository.getBestsellers());
    }

    //todo
    public Page<Book> getPageOfRecommendedBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfNewsBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfPopularBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }

    public Page<Book> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBooksByTitleContaining(searchWord, nextPage);
    }

    public Page<Book> getPageOfRecentBooksResult(Integer offset, Integer limit, Date fromDate, Date toDate) {
        Pageable nextPage = PageRequest.of(offset, limit);
        //return bookRepository.findAllByOrderByPubDateDesc(nextPage);
        return bookRepository.findAllByPubDateBetweenAndOrderByPubDateDesc(fromDate, toDate, nextPage);
        //return bookRepository.findAllByPubDateBetween(fromDate, toDate, nextPage);
    }

    public List<BookDto> toDtos(List<Book> list){
        List<BookDto> res = new ArrayList<>();
        for (Book book: list) {
            res.add(toDTO(book));
        }
        return res;
    }

    private BookDto toDTO(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setImage(book.getImage());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setDiscount(book.getDiscount());
        bookDto.setSlug(book.getSlug());
        bookDto.setPrice(book.getPrice());
        bookDto.setCount_of_buyers(book.getCount_of_buyers());
        bookDto.setCount_of_cart(book.getCount_of_cart());
        bookDto.setCount_of_delay(book.getCount_of_delay());
        bookDto.setDescription(book.getDescription());
        bookDto.setIsBestseller(book.getIsBestseller());
        bookDto.setPubDate(book.getPubDate());
        bookDto.setTitle(book.getTitle());

        return bookDto;
    }
}
