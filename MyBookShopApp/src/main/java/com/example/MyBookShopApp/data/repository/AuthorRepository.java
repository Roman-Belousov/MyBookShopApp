package com.example.MyBookShopApp.data.repository;

import com.example.MyBookShopApp.data.dto.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;


public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {
    @Query("from Author")
    List<Author> findDistinctByLastName();



}
