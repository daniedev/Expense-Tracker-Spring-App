package com.restapistarter.expensetracker;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category;

    public Expense() {
    }

    public Expense(int id, String category) {
        this.id = id;
        this.category = category;
    }

    public Expense(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
}