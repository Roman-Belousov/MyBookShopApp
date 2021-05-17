package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.SearchDateDto;
import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.dto.Book;
import com.example.MyBookShopApp.data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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
        return bookService.getPageOfRecommendedBooks(0,6).getContent();
    }

    @ModelAttribute("newsBooks")
    public List<Book> newsBooks(){
        return bookService.getPageOfRecentBooks(0,6).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks(){
        return bookService.getBooksData();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchResults")
    public List<Book> searchResults(){
        return new ArrayList<>();
    }

    @GetMapping("/")
    public String mainPage() {

        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfRecommendedBooks(offset,limit).getContent());
    }

    @GetMapping(value = {"/search","/search/{searchWord}"})
    public String getSearchResults(@PathVariable(value = "searchWord",required = false) SearchWordDto searchWordDto, Model model){
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults", bookService.getPageOfSearchResultBooks(searchWordDto.getExample(),0,5).getContent());
        return "/search/index";
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit,
                                          @PathVariable(value = "searchWord",required = false) SearchWordDto searchWordDto){
        return new BooksPageDto(bookService.getPageOfSearchResultBooks(searchWordDto.getExample(),offset,limit).getContent());
    }

    @GetMapping("/books/recent")
    @ResponseBody
    public BooksPageDto getRecentBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfRecentBooks(offset,limit).getContent());
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



