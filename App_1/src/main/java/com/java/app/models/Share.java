package com.java.app.models;

public class Share {
    private String date;
    private String company;
    private int price;

    public Share() {}

    public Share(String date, String company, int price) {
        this.date = date;
        this.company = company;
        this.price = price;
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
