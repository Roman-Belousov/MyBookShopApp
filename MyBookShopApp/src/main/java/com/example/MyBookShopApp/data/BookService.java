package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    private  JdbcTemplate jdbcTemplate;
@Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData() {


        List<Book> books = jdbcTemplate.query("SELECT * FROM books",(ResultSet rs, int rowNum)->{
            Book book = new Book();
           book.setId(rs.getInt("id"));
           book.setAuthor(rs.getString("author"));
           book.setTitle(rs.getString("title"));
           book.setPriceOld(rs.getString("priceOld"));
           book.setPrice(rs.getString("price"));


           return book;

        });

        return new ArrayList<>(books);
    }


    public List<Author> getAuthorData() {

       // jdbcTemplate.update("INSERT INTO authors(book_author) SELECT author FROM books ");
        List<Author> authors = jdbcTemplate.query(" SELECT author FROM books ORDER BY author", (ResultSet rs, int rowNum)->{
            Author author = new Author();
            //author.setId(rs.getInt("id"));
            //author.setBook_id(rs.getInt("book_id"));
            author.setBook_author(rs.getString("author"));
            return author;
        });
       // jdbcTemplate.update("DELETE FROM authors ");
        return new ArrayList<>(authors);
    }
}
