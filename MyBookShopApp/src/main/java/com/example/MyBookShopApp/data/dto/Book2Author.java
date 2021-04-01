package com.example.MyBookShopApp.data.dto;

import liquibase.pro.packaged.I;

import javax.persistence.*;

@Entity
@Table(name = "book2author")
public class Book2Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer book_id; //идентификатор книги
    private Integer author_id; //идентификатор автора
    private Integer sort_index; //порядковый номер автора

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Integer getSort_index() {
        return sort_index;
    }

    public void setSort_index(Integer sort_index) {
        this.sort_index = sort_index;
    }

    @Override
    public String toString() {
        return "Book2Author{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", author_id=" + author_id +
                ", sort_index=" + sort_index +
                '}';
    }
}
