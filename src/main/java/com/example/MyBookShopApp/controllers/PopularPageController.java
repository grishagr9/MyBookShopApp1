package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.services.BookService;
import com.example.MyBookShopApp.services.BooksRatingAndPopulatityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class PopularPageController {

    private final BooksRatingAndPopulatityService booksRatingService;

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks(){ return booksRatingService.getBookByPopularity(0,20); }

    @GetMapping("/popular")
    public String popularPage(){
        Logger.getLogger(PopularPageController.class.getName()).info("Page popular start work!");


        return "/books/popular";
    }
}
