package com.example.MyBookShopApp.data.repository;

import com.example.MyBookShopApp.data.dto.Book;
import liquibase.pro.packaged.B;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByAuthor_FirstName(String name);
    @Query("from Book")
    List<Book> customFindAllBooks();

//NEW BOOK REST REPOSITORY COMMANDS

List<Book> findBooksByAuthorFirstNameContaining(String authorFirstName);

List<Book> findBooksByTitleContaining(String bookTitle);

List<Book> findBooksByPriceBetween(Integer min, Integer max);

List<Book> findBooksByPriceIs(Integer price);

@Query("FROM Book WHERE isBestseller=1")
List<Book> getBestsellers();

@Query(value = "SELECT * FROM books WHERE discount = (SELECT MAX (discount) FROM books)", nativeQuery=true)
    List<Book> getBookWithMaxDiscount();

}