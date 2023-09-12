package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.AuthorService;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public MainPageController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("main Page class start work");
        model.addAttribute("bookData", bookService.getBooksData());
        model.addAttribute("searchPlaceholder","new search placeholder");
        return "index";
    }

    @GetMapping("/genres")
    public String toGenres(){
        Logger.getLogger(MainPageController.class.getName()).info("redirect to genres");
        return "genres/index";
    }

    @GetMapping("/authors")
    public String toAuthors(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("redirect to authors");
        model.addAttribute("authorData",authorService.getAuthorsData());
        return "authors/index";
    }

}
