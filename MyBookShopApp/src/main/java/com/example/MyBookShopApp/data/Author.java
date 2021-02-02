package com.example.MyBookShopApp.data;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Author {

    private Integer id;
    private String author_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", author_name='" + author_name + '\'' +
                '}';
    }
}



