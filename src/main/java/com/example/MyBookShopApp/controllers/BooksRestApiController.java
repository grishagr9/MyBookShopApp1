package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.BookDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.services.BookService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
//@Api(description = "book data api")
public class BooksRestApiController {

    private final BookService bookService;

    @GetMapping("/books/by-title")
    //@ApiOperation("Operation to get book by title")
    public ResponseEntity<List<BookDto>> booksByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/by-price-range")
    //@ApiOperation("Operation to get book by price range from min to max")
    public ResponseEntity<List<BookDto>> booksByPriceRange(@RequestParam("min") Integer min, @RequestParam("max") Integer max){
        return ResponseEntity.ok(bookService.getBooksWithPriceBetween(min,max));
    }

    @GetMapping("/books/with-discount")
    //@ApiOperation("Operation to get book with max discount")
    public ResponseEntity<List<BookDto>> maxPriceBooks(){
        return ResponseEntity.ok(bookService.getBooksWithMaxDiscount());
    }

    @GetMapping("/books/bestsellers")
    //@ApiOperation("Operation to get bestsellers")
    public ResponseEntity<List<BookDto>> booksBestsellers(){
        return ResponseEntity.ok(bookService.getBestSellers());
    }
}
