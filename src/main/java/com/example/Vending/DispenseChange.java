package com.example.Vending;

public class DispenseChange implements State{
    private VendingMachine vendingMachine;

    public DispenseChange(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Unable to collect cash in dispense change state");
    }

    @Override
    public void dispenseChange(String productCode) {
        int change = this.vendingMachine.calculateChange(productCode);
        System.out.println("Returning change amount : " + change);
        this.vendingMachine.setState(new DispenseItem(this.vendingMachine));
        this.vendingMachine.dispenseItem(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Unable to dispense item at dispense change state");
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Unable to cancel transaction at cancel transaction state");
    }
}
