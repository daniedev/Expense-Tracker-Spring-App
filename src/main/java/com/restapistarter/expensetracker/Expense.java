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

    private int amount;

    private String category;

    public Expense() {
    }

    public Expense(String category, int amount) {
        this.category = category;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getCategory() { return category; }

    public int getAmount() { return amount; }
}