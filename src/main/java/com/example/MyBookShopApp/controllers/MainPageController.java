package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("main Page class start work");
        model.addAttribute("bookData", bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String toGenres(){
        Logger.getLogger(MainPageController.class.getName()).info("redirect to genres");
        return "genres/index";
    }

    @GetMapping("/authors")
    public String toAuthors(){
        Logger.getLogger(MainPageController.class.getName()).info("redirect to authors");
        return "authors/index";
    }

}
