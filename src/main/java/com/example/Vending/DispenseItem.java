package com.example.Vending;

public class DispenseItem implements State {
    private VendingMachine vendingMachine;

    public DispenseItem(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Unable to collect cash at dispense item state");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Unable to dispense change at dispense item state");
    }

    @Override
    public void dispenseItem(String productCode) {
        vendingMachine.removeProduct(productCode);
        System.out.println("Dispensing item : " + productCode);
        vendingMachine.setState(new Ready(this.vendingMachine));
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Unable to cancel transaction at dispense item state");
    }
}
