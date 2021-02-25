package com.java.app.models;

public class Share {
    private int id;
    private String date;
    private String company;
    private int price;

    public Share() {}

    public Share(int id, String date, String company, int price) {
        this.id = id;
        this.date = date;
        this.company = company;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
