package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

        if (authors.listIterator().hasNext()) {
            String query = "UPDATE books SET authors_id = (SELECT authors.id FROM authors WHERE books.author = authors.author_name)  WHERE id > 0";
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        }
        return new ArrayList<>(authors);
    }
}
