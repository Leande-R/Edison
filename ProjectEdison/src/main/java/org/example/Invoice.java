package org.example;

public class Invoice {


    private static int lastInvoiceID = 0;
    private int InvoiceID;
    private double price;
    private ChargingProcess chargingProcess;

    public Invoice(double price, ChargingProcess chargingProcess) {
        this.InvoiceID = ++lastInvoiceID;
        this.price = price;
        this.chargingProcess = chargingProcess;
    }

    public int getInvoiceID() {
        return InvoiceID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ChargingProcess getChargingProcess() {
        return chargingProcess;
    }

    public void setChargingProcess(ChargingProcess chargingProcess) {
        this.chargingProcess = chargingProcess;
    }

    public void printInvoice() {
        System.out.println("Invoice ID: " + this.InvoiceID);
        System.out.println("Price: " + this.price);
        System.out.println("Charging Process: " + this.chargingProcess);
    }
}