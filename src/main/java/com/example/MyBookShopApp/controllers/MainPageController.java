package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.BookDto;
import com.example.MyBookShopApp.dto.BooksPageDto;
import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.services.BookService;
import com.example.MyBookShopApp.services.TagService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private final BookService bookService;

    private final TagService tagService;

    @ModelAttribute("recommendedBooks")
    public List<BookDto> recommendedBooks(){
        List<Book> res = bookService.getPageOfRecommendedBooks(0,6).getContent();
        return bookService.toDtos(res);
    }

    @ModelAttribute("popularBooks")
    public List<BookDto> popularBooks(){ return bookService.toDtos(bookService.getPageOfPopularBooks(0,6).getContent()); }

    @ModelAttribute("newBooks")
    public List<BookDto> newBooks(){ return bookService.toDtos(bookService.getPageOfNewsBooks(0,6).getContent()); }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<BookDto> searchResults(){
        return new ArrayList<>();
    }

    @ModelAttribute("booksTagResult")
    public List<BookDto> booksTagResult(){return new ArrayList<>(); }

    @GetMapping("/")
    public String mainPage(Model model){
        Logger.getLogger(MainPageController.class.getName()).info("main Page class start work");
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset")Integer offset,@RequestParam("limit")Integer limit){
        return new BooksPageDto(bookService.toDtos(bookService.getPageOfRecommendedBooks(offset,limit).getContent()));
    }

    @GetMapping("/books/recent")
    @ResponseBody
    public BooksPageDto getBooksPageNews(@RequestParam("offset")Integer offset,@RequestParam("limit")Integer limit){
        return new BooksPageDto(bookService.toDtos(bookService.getPageOfNewsBooks(offset, limit).getContent()));
    }

    @GetMapping("/books/popular")
    @ResponseBody
    public BooksPageDto getBooksPagePopular(@RequestParam("offset")Integer offset,@RequestParam("limit")Integer limit){
        return new BooksPageDto(bookService.toDtos(bookService.getPageOfPopularBooks(offset,limit).getContent()));
    }

    @GetMapping(value = {"/search/", "/search/{searchWord}"})
    public String getSearchResult(@PathVariable(value = "searchWord",required = false) SearchWordDto searchWordDto,
                                  Model model ){
        model.addAttribute("searchWordDto",searchWordDto);
        model.addAttribute("searchResults",bookService
                .getPageOfSearchResultBooks(searchWordDto.getExample(),0,5).getContent());
        return "/search/index";
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset")Integer offset,
                                          @RequestParam("limit")Integer limit,
                                          @PathVariable(value = "searchWord",required = false) SearchWordDto searchWordDto){
        return new BooksPageDto(bookService.toDtos(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(),offset,limit).getContent()));
    }
    @ModelAttribute("textTag")
    public List<TagsDto> textTag(){ return tagService.getAllTags(); }

    @GetMapping(value = "/tags")
    public String tagsPage(Model model){
        Logger.getLogger(TagsPageController.class.getSimpleName()).info("tags page start work");
        model.addAttribute("textTag",textTag());
        return "/tags/index";
    }

    @GetMapping(value ="/tags/{nameTag}")
    public String getTagsPage(@PathVariable(value = "nameTag",required = false)String nameTag, Model model){
        Logger.getLogger(TagsPageController.class.getSimpleName()).info("tags page start work   ");
        model.addAttribute("booksTagResult", tagService.getBooksFromTag(nameTag));
        return "tags/index";
    }

    @GetMapping("/postponed")
    public String postponedPage(){
        return "postponed";
    }

    @GetMapping("/cart")
    public String cartPage(){
        return "cart";
    }

    @GetMapping("/signin")
    public String signinPage(){
        return "signin";
    }



    @GetMapping("/documents")
    public String documentsPage(){
        return "/documents/index";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

    @GetMapping("/faq")
    public String faqPage(){
        return "faq";
    }

    @GetMapping("/contacts")
    public String contactsPage(){
        return "contacts";
    }


}
