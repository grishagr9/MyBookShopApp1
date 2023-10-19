package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.BookDto;
import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.services.AuthorService;
import com.example.MyBookShopApp.entity.Authors;

import io.swagger.v3.oas.annotations.Operation;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AuthorsPageController {

    private final AuthorService authorService;

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<BookDto> searchResults(){
        return new ArrayList<>();
    }

    @ModelAttribute("authorsMap")
    public Map<String,List<Authors>> authorsMap(){
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }


    @GetMapping("/authors/{nameAuthor}")
    public String getAuthorsPage(@PathVariable(value = "nameAuthor",required = false)String nameAuthor, Model model){
        model.addAttribute("booksByAuthor", authorService.getBookByAuthor(nameAuthor));
        model.addAttribute("currentAuthor", authorService.getAuthorByName(nameAuthor));
        return "authors/slug";
    }


    @Operation(summary = "Get authors by id")
    @GetMapping("/api/authors")
    @ResponseBody
    public Map<String, List<Authors>> authors(){
        return authorService.getAuthorsMap();
    }
}
