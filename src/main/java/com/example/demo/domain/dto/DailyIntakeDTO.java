package com.example.demo.domain.dto;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Date;

public class DailyIntakeDTO {

//    @Value("${meal.calorie-limit}")
    private final int LIMIT = 2000;
    private Date date;
    private int caloriesTotal;
    private String status;

    public DailyIntakeDTO() {
    }

    public DailyIntakeDTO(Date date, int caloriesTotal) {
        this.date = date;
        this.caloriesTotal = caloriesTotal;
        if (caloriesTotal == LIMIT) {
            this.status = "EXACT";
        } else {
            this.status = (caloriesTotal < LIMIT) ? "BELOW" : "ABOVE";
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCaloriesTotal() {
        return caloriesTotal;
    }

    public void setCaloriesTotal(int caloriesTotal) {
        this.caloriesTotal = caloriesTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
