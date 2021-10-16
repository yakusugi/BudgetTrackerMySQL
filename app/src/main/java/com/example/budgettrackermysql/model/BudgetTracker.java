package com.example.budgettrackermysql.model;

import java.util.Date;

public class BudgetTracker {

    private int id;
    private Date date;
    private String storeName;
    private String productName;
    private String type;
    private int price;

    public BudgetTracker() {
    }

    public BudgetTracker(int id, Date date, String storeName, String productName, String type, int price) {
        this.id = id;
        this.date = date;
        this.storeName = storeName;
        this.productName = productName;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
