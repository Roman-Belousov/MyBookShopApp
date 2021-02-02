package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @PostConstruct
    public void setAuthorId() throws SQLException {

        String query = "UPDATE books SET authors_id = (SELECT authors.id FROM authors WHERE books.author = authors.author_name)  WHERE id > 0";
        Connection connection = jdbcTemplate.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();

    }


    public List<Book> getBooksData() {

        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
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

    public List<Author> getAuthorData() throws SQLException {

        List<Author> authors = jdbcTemplate.query(" SELECT * FROM authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setAuthor_name(rs.getString("author_name"));

            return author;
        });

        Map<String, List<Author>> map = authors.stream().collect(Collectors.groupingBy((Author author) -> author.getAuthor_name().substring(0, 1)));

        return new ArrayList<>(authors);
    }
}



