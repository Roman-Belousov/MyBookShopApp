package com.example.MyBookShopApp.data;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


import javax.persistence.NamedQuery;
import java.util.List;


public interface AuthorRepository extends PagingAndSortingRepository<Author, Integer> {
    @Query("from Author")
    List<Author> findDistinctByLastName();



}
