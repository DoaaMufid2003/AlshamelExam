package com.example.alshamelexam.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryProduct {
    @SerializedName("products")
    List<Product> products;

    public CategoryProduct() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
