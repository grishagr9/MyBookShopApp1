package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.ResourceStorage;
import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.channels.MulticastChannel;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookRepository bookRepository;
    private final ResourceStorage storage;

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @GetMapping("/{slug}")
    public String bookPage(@PathVariable("slug") String slug, Model model){
        Book book = bookRepository.findBooksBySlug(slug);
        model.addAttribute("slugBook", book);

        return "/books/slug";
    }

    @PostMapping("/{slug}/img/save")
    public String saveNewBookImage(@RequestParam("file")MultipartFile file, @PathVariable("slug") String slug) throws IOException {
        String savePath = storage.saveNewBookImage(file, slug);
        Book bookToUpdate = bookRepository.findBooksBySlug(slug);
        bookToUpdate.setImage(savePath);
        bookRepository.save(bookToUpdate); //save new path in db here

        return ("redirect:/books/"+slug);
    }
}
