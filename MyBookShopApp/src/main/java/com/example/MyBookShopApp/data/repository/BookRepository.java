package com.example.MyBookShopApp.data.repository;

import com.example.MyBookShopApp.data.dto.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByAuthor_FirstName(String name);
    @Query("from Book")
    List<Book> customFindAllBooks();

}
