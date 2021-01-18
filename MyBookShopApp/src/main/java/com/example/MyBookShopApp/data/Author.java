package com.example.MyBookShopApp.data;



public class Author {

    private Integer id;
    private Integer book_id;
    private String book_author;

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

    public String getBook_author() {
        return book_author;
    }
    public void setBook_author(String book_author) {
        this.book_author = book_author;


    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", book_id=" + book_id +
                ", book_author='" + book_author + '\'' +
                '}';
    }
}



