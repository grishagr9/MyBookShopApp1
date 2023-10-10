package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.GenresDto;
import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.entity.genre.GenreEntity;
import com.example.MyBookShopApp.services.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class GenresPageController {

    final private GenreService genreService;
    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("booksGenres")
    public Map<Integer, GenresDto> booksGenres(){
        return genreService.getAllGenres();
    }

    @ModelAttribute("bookGenreResult")
    public List<Book> bookGenreResult(){ return new ArrayList<>(); }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }

    @GetMapping("/genres")
    public String genresPage(Model model){
        model.addAttribute("booksGenres", booksGenres().values().stream().filter(f -> f.getParent()==0));
        return "/genres/index";
    }

    @GetMapping(value ="/genres/{nameGenre}")
    public String getGenrePage(@PathVariable(value = "nameGenre",required = false)String nameGenre, Model model){
        GenreEntity genre = genreService.getGenreByName(nameGenre);
        model.addAttribute("bookGenreResult", genreService.getAllBookByName(nameGenre));
        model.addAttribute("currentGenre",genre);
        if(genre!=null && genre.getParentId() != 0){
           model.addAttribute("parentGenre", genreService.getParentGenre(genre));
        }
        return "genres/slug";
    }
}
