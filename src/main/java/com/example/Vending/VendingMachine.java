package com.example.Vending;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Map<Integer, Integer> collectedCash;
    private final Map<String, List<Item>> productMap;
    private State state;
    private int cash;

    public VendingMachine(Map<String, List<Item>> productMap) {
        this.productMap = new HashMap<>();
        this.collectedCash = new HashMap<>();
    }

    public void addCollectedCash(int cash) {
        this.cash = cash;
        collectedCash.put(cash, collectedCash.getOrDefault(cash, 0) + 1);
    }

    public int getCollectedCash() {
        int amount = this.cash;
        collectedCash.put(cash, collectedCash.get(cash)-1);
        this.cash = 0;
        return amount;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void cancelTransaction() {
        this.state.cancelTransaction();
    }

    public void dispenseChange(String productCode) {
        this.state.dispenseChange(productCode);
    }

    public void dispenseItem(String productCode) {
        this.state.dispenseItem(productCode);
    }

    public int calculateChange(String productCode) {
        return this.cash - this.productMap.get(productCode).get(0).getPrice();
    }

    public void removeProduct(String productCode) {

    }

}
