package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("bookData",bookService.getBooksData());
        return "index";
    }

    @GetMapping("/genres")
    public String genresPage(Model model) {
        return "genres";
    }

    @GetMapping("/author")
    public String authorPage(Model model) throws SQLException {
        try {
            model.addAttribute("authorData",bookService.getAuthorData());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "author";
    }
}
