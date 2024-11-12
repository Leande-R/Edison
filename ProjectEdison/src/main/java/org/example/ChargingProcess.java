package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
public class ChargingProcess {

    private int CpId;
    private Customer customer;
    private ChargingStation chargingStation;
    private Charger charger;
    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;


    public ChargingProcess () {}


    public ChargingProcess(Customer customer, Charger charger) {
        this.customer = customer;
        this.charger = charger;
    }

    public ChargingProcess(Customer customer, Charger charger, LocalDateTime startTime, LocalDateTime endTime) {
        this.customer = customer;
        this.charger = charger;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public ChargingProcess(int cpId, Customer customer, Charger charger, LocalDateTime startTime, LocalDateTime endTime) {
        this.CpId = cpId;
        this.customer = customer;
        this.charger = charger;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public int getCpId() {
        return CpId;
    }

    public void setCpId(int cpId) {
        this.CpId = cpId;
    }



    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer.getId(), customer.getName(), customer.getMail(), customer.getCredit());
    }



    private Charger getCharger() {
        return charger;
    }


    public void setCharger(Charger charger) {
        this.charger = charger;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }



    public void chargeVehicle() {
        ChargingStation station = charger.getChargingStation();
        double pricePerMinute;

        if (charger.getChargingMethod() == ChargingMethod.AC) {
            pricePerMinute = station.getPriceAC();
        } else if (charger.getChargingMethod() == ChargingMethod.DC) {
            pricePerMinute = station.getPriceDC();
        } else {
            throw new IllegalArgumentException("Unknown charging method: " + charger.getChargingMethod());
        }

        long durationMinutes = Duration.between(startTime, endTime).toMinutes();
        double totalPrice = durationMinutes * pricePerMinute;

        customer.setCredit(customer.getCredit() - totalPrice);
    }



    public void chargeVehicle(LocalDateTime startTime, long durationMinutes) {
        ChargingStation station = charger.getChargingStation();
        double pricePerMinute;

        if (charger.getChargingMethod() == ChargingMethod.AC) {
            pricePerMinute = station.getPriceAC();
        } else if (charger.getChargingMethod() == ChargingMethod.DC) {
            pricePerMinute = station.getPriceDC();
        } else {
            throw new IllegalArgumentException("Unknown charging method: " + charger.getChargingMethod());
        }

        LocalDateTime endTime = startTime.plusMinutes(durationMinutes);
        double totalPrice = durationMinutes * pricePerMinute;

        customer.setCredit(customer.getCredit() - totalPrice);

    }

    public double calculateTotalPrice() {
        ChargingStation station = charger.getChargingStation();
        double pricePerMinute;

        if (charger.getChargingMethod() == ChargingMethod.AC) {
            pricePerMinute = station.getPriceAC();
        } else if (charger.getChargingMethod() == ChargingMethod.DC) {
            pricePerMinute = station.getPriceDC();
        } else {
            throw new IllegalArgumentException("Unknown charging method: " + charger.getChargingMethod());
        }
        charger.setChargingStatus(ChargingStatus.OCCUPIED);

        long durationMinutes = Duration.between(startTime, endTime).toMinutes();


        customer.setCredit(customer.getCredit() - durationMinutes * pricePerMinute);

        charger.setChargingStatus(ChargingStatus.IN_OPERATION_FREE);

        return durationMinutes * pricePerMinute;



    }


    public ChargingStation getChargingStation() {
        return chargingStation;
    }

    public void setChargingStation(ChargingStation chargingStation) {
        this.chargingStation = chargingStation;
    }

    private void generateInvoice(double totalPrice, ChargingProcess chargingProcess) {
        Invoice invoice = new Invoice(totalPrice, this);
        invoice.printInvoice();
    }

    public int getDurationMinutes() {
        return (int) Duration.between(startTime, endTime).toMinutes();
    }

    public void setStartTime(LocalDateTime parse) {
        this.startTime = parse;
    }
}


