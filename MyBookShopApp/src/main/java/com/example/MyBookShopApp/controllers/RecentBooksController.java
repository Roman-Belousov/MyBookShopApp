package com.example.MyBookShopApp.controllers;


import com.example.MyBookShopApp.data.BooksPageDto;
import com.example.MyBookShopApp.data.SearchDateDto;
import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.dto.Author;
import com.example.MyBookShopApp.data.dto.Book;
import com.example.MyBookShopApp.data.service.BookService;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@Api(description = "recent book data")
public class RecentBooksController {

    private BookService bookService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");


//    @DateTimeFormat
//   Date enddaterecent = DateUtils.addDays(new Date(),-41);
//
//    @DateTimeFormat
//    Date fromdaterecent = DateUtils.addDays(new Date(),1);

    @Autowired
    public RecentBooksController(BookService bookService) {
        this.bookService = bookService;

    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("searchDateDto")
    public SearchDateDto searchDateDto(){
        return new SearchDateDto();
    }




    @ModelAttribute("searchDateResults")
    public List<Book> searchDateResults(){
        return new ArrayList<>();
    }


    @GetMapping ("/recent")

    public String  getSearchResults(Model model)  {

        model.addAttribute("searchDateResults", bookService.getPageOfRecentBooksBetween(0,5,
                LocalDate.now().minusMonths(2) , LocalDate.now()).getContent());

        return "/books/recent";
    }

    @PostMapping ("/recent/searchBetweenPubDate")

    public String  getSearchResults(@DateTimeFormat SearchDateDto searchDateDto, Model model)  {

        System.out.println(LocalDate.parse(searchDateDto.getFromdaterecent(),formatter));


        model.addAttribute("searchDateResults",bookService.getPageOfRecentBooksBetween(0,5, LocalDate.parse(searchDateDto.getFromdaterecent(),formatter),LocalDate.parse(searchDateDto.getEnddaterecent(),formatter)).getContent());
model.addAttribute("searchDateDto", new SearchDateDto());


        return "/books/recent";
    }
}
