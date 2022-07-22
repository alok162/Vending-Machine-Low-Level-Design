package com.example.Vending;

public class Item {

    private int price;
    private int quantity;

    public Item(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void decrementQuantity() {
        this.quantity--;
    }

    public void addQuantity() {
        this.quantity++;
    }
}
