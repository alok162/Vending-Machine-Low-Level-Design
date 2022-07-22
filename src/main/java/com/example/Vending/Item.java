package com.example.Vending;

public abstract class Item {

    private Items item;
    private int price;
    private int quantity;

    public Item(Items item, int price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void deductQuantity() {
        this.quantity--;
    }

    public void addQuantity() {
        this.quantity++;
    }
}
