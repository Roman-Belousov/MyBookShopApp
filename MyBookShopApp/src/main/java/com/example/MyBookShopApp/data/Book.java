package com.example.MyBookShopApp.data;

public class Book {

    private Integer id;
    private String author;
    private String title;
    private String priceOld;
    private String price;
    private Integer authors_id;

    public Integer getAuthors_id() {
        return authors_id;
    }

    public void setAuthors_id(Integer authors_id) {
        this.authors_id = authors_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", priceOld='" + priceOld + '\'' +
                ", price='" + price + '\'' +
                ", authors_id=" + authors_id +
                '}';
    }
}
