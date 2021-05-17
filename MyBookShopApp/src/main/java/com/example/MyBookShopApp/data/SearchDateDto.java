package com.example.MyBookShopApp.data;

import java.time.LocalDate;
import java.util.Date;

public class SearchDateDto {

    private String fromdaterecent;
    private String enddaterecent;

    public SearchDateDto(String fromdaterecent, String enddaterecent) {
        this.fromdaterecent = fromdaterecent;
        this.enddaterecent = enddaterecent;
    }

    public SearchDateDto() {

    }

    public String getFromdaterecent() {
        return fromdaterecent;
    }

    public void setFromdaterecent(String fromdaterecent) {
        this.fromdaterecent = fromdaterecent;
    }

    public String getEnddaterecent() {
        return enddaterecent;
    }

    public void setEnddaterecent(String enddaterecent) {
        this.enddaterecent = enddaterecent;
    }
}



