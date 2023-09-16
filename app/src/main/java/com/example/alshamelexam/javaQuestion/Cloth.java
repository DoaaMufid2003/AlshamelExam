package com.example.alshamelexam.javaQuestion;

public class Cloth {
    int id;
    String model;
    String color;
    int price;
    int quantity;
    size size;

    public Cloth() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public com.example.alshamelexam.javaQuestion.size getSize() {
        return size;
    }

    public void setSize(com.example.alshamelexam.javaQuestion.size size) {
        this.size = size;
    }

    public  double totalPrice(int price, int quantity){
        double total=price*quantity;
        if (quantity>10){
            total=total-(quantity*0.02);
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cloth{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", size=" + size +
                '}';
    }
}
enum size{small, medium,large,xl,xxl,xxxl}
