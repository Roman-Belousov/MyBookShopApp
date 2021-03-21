package com.example.MyBookShopApp.data.dto;

import javax.persistence.*;

@Entity
@Table(name = "faqs")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer sort_index; //порядковый номер вопроса в списке вопросов на странице “Помощь”
    private String question; //вопрос
    private String answer; //ответ в формате HTML

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "id=" + id +
                ", sort_index=" + sort_index +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
