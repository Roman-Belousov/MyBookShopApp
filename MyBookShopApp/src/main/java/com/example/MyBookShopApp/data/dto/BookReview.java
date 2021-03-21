package com.example.MyBookShopApp.data.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book_reviews")
public class BookReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book; //идентификатор книги
    @OneToOne
    @JoinColumn(name="user_id")
    private User user; //идентификатор пользователя, который написал данный отзыв
    private Date time; //время, когда оставлен отзыв
    private String text; //текст отзыва

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "BookReview{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", time=" + time +
                ", text='" + text + '\'' +
                '}';
    }
}
