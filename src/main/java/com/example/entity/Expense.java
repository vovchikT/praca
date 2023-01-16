package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Expense() {}

    public Expense(String description, Double value, Date date, String category, User user) {
        this.description = description;
        this.value = value;
        this.date = date;
        this.category = category;
        this.user = user;
    }

    @Column(name="description")
    private String description;

    @Column(name="value")
    private Double value;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    @Column(name="date")
    private Date date;

    @Column(name="category")
    private String category;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id", nullable = false)
    private User user;


}
