package com.example.dto;

import com.example.entity.Expense;

import java.sql.Date;

public class ExpenseDto {

    private Long id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String description;
    private String category;
    private Double value;
    private Date date;

    public ExpenseDto(Long id, String description, String category, Double value, Date date) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.value = value;
        this.date = date;
    }


    public Long getId() {
        return id;
    }
}
