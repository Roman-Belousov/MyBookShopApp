package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.dto.Book;
import com.example.MyBookShopApp.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getBooksData();
    }

    @ModelAttribute("newsBooks")
    public List<Book> newsBooks(){
        return bookService.getBooksData();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks(){
        return bookService.getBooksData();
    }

    @GetMapping("/")
    public String mainPage() {

        return "index";
    }
    @GetMapping("/recent")
    public String recentPage() {

        return "/books/recent";
    }
    @GetMapping("/genres")
    public String genresPage() {

        return "/genres/index";
    }
    @GetMapping("/popular")
    public String popularPage() {

        return "/books/popular";
    }
    @GetMapping("/signin")
    public String signinPage() {

        return "signin";
    }
    @GetMapping("/cart")
    public String cartPage() {

        return "cart";
    }
    @GetMapping("/postponed")
    public String postponedPage() {

        return "postponed";
    }
    @GetMapping("/signup")
    public String signupPage() {

        return "signup";
    }
}



