package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PopularPageController {

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }
    @GetMapping("/popular")
    public String popularPage(){
        return "/books/popular";
    }
}
