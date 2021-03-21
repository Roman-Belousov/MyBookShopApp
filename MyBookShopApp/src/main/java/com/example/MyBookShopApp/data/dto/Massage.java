package com.example.MyBookShopApp.data.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "massages")
public class Massage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date time; //дата и время отправки сообщения
    private Integer user_id; // если пользователь был авторизован
    private String e_mail; //электронная почта пользователя, если он не был авторизован
    private String name; //имя пользователя, если он не был авторизован
    private String subject; //тема сообщения
    private String text; //текст сообщения

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Massage{" +
                "id=" + id +
                ", time=" + time +
                ", user_id=" + user_id +
                ", e_mail='" + e_mail + '\'' +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
