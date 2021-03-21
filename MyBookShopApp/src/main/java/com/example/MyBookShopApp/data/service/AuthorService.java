package com.example.MyBookShopApp.data.service;

import com.example.MyBookShopApp.data.dto.Author;
import com.example.MyBookShopApp.data.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<String,List<Author>> getAuthorsData() {

        return authorRepository.findDistinctByLastName().stream().distinct().collect(Collectors.groupingBy((Author a) ->
        {return a.getLastName().substring(0,1);}));
    }
}



