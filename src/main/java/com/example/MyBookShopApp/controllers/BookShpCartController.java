package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.dto.SearchWordDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.repositories.BookRepository;
import jakarta.persistence.PostRemove;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Controller
@RequestMapping("/books")
public class BookShpCartController {

    @ModelAttribute(name = "bookCart")
    public List<Book> bookCart(){
        return new ArrayList<>();
    }

    private final BookRepository bookRepository;

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }
    @Autowired
    public BookShpCartController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/cart")
    public String handleCartRequest(@CookieValue(value = "cartContents", required = false) String cartContents, Model model){
        if(cartContents == null || cartContents.equals("")){
            model.addAttribute("isCartEmpty", true);
        }else{
            model.addAttribute("isEmpty", false);
            cartContents = cartContents.startsWith("/") ? cartContents.substring(1) : cartContents;
            cartContents = cartContents.endsWith("/") ? cartContents.substring(0,cartContents.length()-1) : cartContents;
            String[] cookieSlugs = cartContents.split("/");
            List<Book> booksFromCookieSlug = bookRepository.findBooksBySlugIn(cookieSlugs);
            model.addAttribute("bookCart", booksFromCookieSlug);
        }

        return "cart";
    }

    @PostMapping("/changeBookStatus/{slug}")
    public String handleChangeBookStatus(@PathVariable("slug") String slug, @CookieValue(name = "cartContents",
            required = false) String cartContents, HttpServletResponse response, Model model){

        if(cartContents == null || cartContents.equals("")){
            Cookie cookie = new Cookie("cartContents", slug);
            cookie.setPath("/books");
            response.addCookie(cookie);
            model.addAttribute("isCartEmpty", false);
        }else if(!cartContents.contains(slug)){
            StringJoiner stringJoiner = new StringJoiner("/");
            stringJoiner.add(cartContents).add(slug);
            Cookie cookie = new Cookie("cartContents", stringJoiner.toString());
            cookie.setPath("/books");
            response.addCookie(cookie);
            model.addAttribute("isCartEmpty", false);
        }
        return "redirect:/books/" + slug;
    }
}
