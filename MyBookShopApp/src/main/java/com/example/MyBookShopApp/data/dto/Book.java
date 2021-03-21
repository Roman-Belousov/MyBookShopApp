package com.example.MyBookShopApp.data.dto;

import com.example.MyBookShopApp.data.dto.Author;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    private String title;
    private Date pub_date;
    private Integer is_bestseller;
    private String slug;
    private String image;
    private String description;
    private Integer discount;
    private String priceOld;
    private String price;

    @OneToMany(mappedBy = "book")
    private List<BookReview> bookReviews = new ArrayList<>();

    public List<BookReview> getBookReviews() {
        return bookReviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    public Integer getIs_bestseller() {
        return is_bestseller;
    }

    public void setIs_bestseller(Integer is_bestseller) {
        this.is_bestseller = is_bestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(String priceOld) {
        this.priceOld = priceOld;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", pub_date=" + pub_date +
                ", is_bestseller=" + is_bestseller +
                ", slug='" + slug + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                ", priceOld='" + priceOld + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
