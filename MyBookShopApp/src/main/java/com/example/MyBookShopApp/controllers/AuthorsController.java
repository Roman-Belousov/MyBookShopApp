package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.SearchWordDto;
import com.example.MyBookShopApp.data.dto.Author;
import com.example.MyBookShopApp.data.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Api(description = "authors data")
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        return authorService.getAuthorsData();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto(){
        return new SearchWordDto();
    }

    @GetMapping("/authors")
    public String authorsPage() {
        return "/authors/index";
    }

    @ApiOperation("method to get data of authors")
    @GetMapping("/api/authors")
    @ResponseBody
    public Map<String, List<Author>> authors(){
        return authorService.getAuthorsData();
    }
}
