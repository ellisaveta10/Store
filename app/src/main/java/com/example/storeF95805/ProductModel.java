package com.example.storeF95805;

import androidx.annotation.NonNull;

public class ProductModel {
    private String id;
    private String title;
    private double price;

    public ProductModel() {
        this.id = "";
        this.title = "";
        this.price = 0.0;
    }

    public ProductModel(String id, String title, double price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @NonNull
    @Override
    public String toString() {
        return "ProductModel{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
