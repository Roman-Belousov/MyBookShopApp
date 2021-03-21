package com.example.MyBookShopApp.data.dto;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(mappedBy ="user")
    private UserContact userContact;
	private String hash;
	private Date reg_time;
	private Integer balance;
	private  String name;
    @OneToOne(mappedBy = "user")
    private BookReview bookReview;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getReg_time() {
        return reg_time;
    }

    public void setReg_time(Date reg_time) {
        this.reg_time = reg_time;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", reg_time=" + reg_time +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
