package com.example.MyBookShopApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class MyBookShopAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyBookShopAppApplication.class, args);

	}
}
