package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("bookshop/authors")
public class AuthorsPageController {

    @GetMapping("/genres")
    public String toGenres(){
        return "genres/index";
    }

}
