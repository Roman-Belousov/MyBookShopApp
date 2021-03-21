package com.example.MyBookShopApp.data.dto;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer	id;

private Integer	sort_index; // порядковый номер документа (для вывода на странице списка документов)
private String	slug; //мнемонический код документа, отображаемый в ссылке на страницу документа
private String	title; //наименование документа
private String	text; //текст документа в формате HTML

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort_index() {
        return sort_index;
    }

    public void setSort_index(Integer sort_index) {
        this.sort_index = sort_index;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", sort_index=" + sort_index +
                ", slug='" + slug + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
