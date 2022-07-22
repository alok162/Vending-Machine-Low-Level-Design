package com.example.Vending;

public class CancelTransaction implements State {
    private VendingMachine vendingMachine;

    public CancelTransaction(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Unable to collect cash in cancel transaction state");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Unable to dispense change in cancel transaction state");
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Unable to collect item in cancel transaction state");
    }

    @Override
    public void cancelTransaction() {
        int amount = this.vendingMachine.getCollectedCash();
        System.out.println("Returning amount : " + amount);
        this.vendingMachine.setState(new Ready(this.vendingMachine));
    }
}
