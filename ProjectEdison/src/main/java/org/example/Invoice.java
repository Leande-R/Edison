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
        System.out.println("Rate for AC charging: " + this.chargingProcess.getChargingStation().getPriceAC() + "€ per kWh");
        System.out.println("Total cost for energy consumed: " + this.price + "€");
        System.out.println("Charging station name: " + this.chargingProcess.getChargingStation().getCsName());
        System.out.println("Location: " + this.chargingProcess.getChargingStation().getLocation());
        System.out.println("Charging process started at: " + this.chargingProcess.getStartTime());
        System.out.println("Charging process ended at: " + this.chargingProcess.getEndTime());
        System.out.println("Duration of the charging session: " + this.chargingProcess.getDurationMinutes() + " minutes");
    }
}