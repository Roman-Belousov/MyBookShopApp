package com.example.MyBookShopApp.data.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_contact")
public class UserContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user; //идентификатор пользователя, к которому относится данный контакт

    private EnumType type; //тип контакта (телефон или e-mail)
    private Integer approved; //подтверждён ли контакт (0 или 1)
    private String code; //код подтверждения
    private Integer code_trials;// количество попыток ввода кода подтверждения
    private Date code_time; // дата и время формирования кода подтверждения
    private String contact; //контакт (e-mail или телефон)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    public Integer getApproved() {
        return approved;
    }

    public void setApproved(Integer approved) {
        this.approved = approved;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCode_trials() {
        return code_trials;
    }

    public void setCode_trials(Integer code_trials) {
        this.code_trials = code_trials;
    }

    public Date getCode_time() {
        return code_time;
    }

    public void setCode_time(Date code_time) {
        this.code_time = code_time;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "UserContact{" +
                "id=" + id +
                ", user=" + user +
                ", type=" + type +
                ", approved=" + approved +
                ", code='" + code + '\'' +
                ", code_trials=" + code_trials +
                ", code_time=" + code_time +
                ", contact='" + contact + '\'' +
                '}';
    }
}
