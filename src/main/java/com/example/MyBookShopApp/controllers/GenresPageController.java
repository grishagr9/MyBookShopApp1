package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("bookshop/genres")
public class GenresPageController {

    @GetMapping("/authors")
    public String toAuthors(){
        Logger.getLogger(GenresPageController.class.getName()).info("redirect to authors page (from genres)");
        return "authors/index";
    }
}
