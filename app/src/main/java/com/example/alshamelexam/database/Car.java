package com.example.alshamelexam.database;

public class Car {
    String name;
    int model;
    int id;
    String color;

    public Car(String name, int model, String color) {
        this.name = name;
        this.model = model;
        this.color = color;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car(int id) {
        this.id = id;
    }

    public Car(String name, int model, int id, String color) {
        this.name = name;
        this.model = model;
        this.id = id;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
