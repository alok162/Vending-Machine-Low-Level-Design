package com.example.Vending;

public class Ready implements State{
    private VendingMachine vendingMachine;

    public Ready(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        this.vendingMachine.addCollectedCash(cash);
    }

    @Override
    public void dispenseChange(String productCode) {
        this.vendingMachine.setState(new DispenseChange(this.vendingMachine));
        this.vendingMachine.dispenseChange(productCode);
    }

    @Override
    public void dispenseItem() {
        throw new RuntimeException("Transaction not initiated, unable to dispense item");
    }

    @Override
    public void cancelTransaction() {
        this.vendingMachine.setState(new CancelTransaction(this.vendingMachine));
        this.vendingMachine.cancelTransaction();
    }
}
