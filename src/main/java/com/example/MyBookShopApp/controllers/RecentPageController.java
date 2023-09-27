package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.BooksPageDto;
import com.example.MyBookShopApp.dto.DateRecentDto;
import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.services.BookService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RecentPageController {

    private final BookService bookService;

    public RecentPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }

    @ModelAttribute("recentBooks")
    public List<Book> recentBooks(){ return new ArrayList<>(); }

    @ModelAttribute("fromDate")
    public DateRecentDto fromDatePub(){ return new DateRecentDto();}

    @ModelAttribute("toDate")
    public DateRecentDto toDatePub(){ return new DateRecentDto();}

    @GetMapping("/recent")
    public String resentPage(@RequestParam(value = "fromDate", required = false)DateRecentDto fromDate,
                             @PathVariable(value = "toDate", required = false)DateRecentDto toDate,
                             Model model) {
        model.addAttribute("fromDate",fromDate);
        model.addAttribute("toDate",toDate);
        model.addAttribute("recentBooks",
                bookService.getPageOfRecentBooksResult(0,5,fromDate.getDate(),toDate.getDate()).getContent());
        return "/books/recent";
    }

}
