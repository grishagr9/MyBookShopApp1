package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.services.AuthorService;
import com.example.MyBookShopApp.entity.Authors;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
@Api(description = "authors data")
public class AuthorsPageController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsPageController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String,List<Authors>> authorsMap(){
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }


    @ApiOperation("method to get map of authors")
    @GetMapping("/api/authors")
    public Map<String, List<Authors>> authors(){
        return authorService.getAuthorsMap();
    }
}
