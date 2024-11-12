package org.example;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChargingProcessMonitoringStepDefinitions {


    @ParameterType("[-+]?\\d*\\.?\\d+")
    public double d(String value) {
        return Double.parseDouble(value);
    }
    private ChargingProcess chargingProcess = new ChargingProcess();
    private ChargingStation chargingStation =  new ChargingStation();
    private Customer customer = new Customer();
    private Charger charger = new Charger();
    private Invoice invoice;
    private int credit;

    private int maxBatteryCapacity;
    private int currentCapacity;

    @Given("My Customer Name is {string}")
    public void myCustomerNameIs(String name) {

        customer.setName(name);
    }

    @And("my credit is {double} €")
    public void myCreditIs€(double amount) {
        customer.topUpCredit(amount);
    }

    @And("my vehicle has a maximum Battery capacity of {int} kW")
    public void myVehicleHasAMaximumBatteryCapacityOfKW(int maxKw) {
        this.maxBatteryCapacity = maxKw;
    }

    @And("the current capacity is at {int} kW")
    public void theCurrentCapacityIsAtKW(int cuKW) {
        this.currentCapacity = cuKW;
    }

    @And("I was at the charging Station {string}")
    public void iWasAtTheChargingStation(String CsName) {
        chargingStation.setCsName(CsName);
    }
    @And("the station is located at the address {string}")
    public void theStationIsLocatedAtTheAddress(String location) {
        chargingStation.setLocation(location);
    }
    @And("the Price for AC at {string} is {double}€ per KwH")
    public void thePriceForACAtIs€PerKwH(String location, double ACPrice) {
        chargingStation.setPriceAC(ACPrice);
    }

    @And("the Price for DC at {string} is {double}€ per KwH")
    public void thePriceForDCAtIs€PerKwH(String location, double DCPrice) {
        chargingStation.setPriceDC(DCPrice);
    }

    @And("the Standing fee is {double}€ per minute")
    public void theStandingFeeIs€PerMinute(double standingFee) {
        assertEquals (chargingStation.getStandingFee(), standingFee);
    }



    @And("the charging process started at {string}")
    public void theChargingProcessStartedAt(String startTime) {
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        chargingProcess.setStartTime(start);

    }

    @And("the charging process ended at {string}")
    public void theChargingProcessEndedAt(String endTime) {
        LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        charger.setChargingMethod(ChargingMethod.AC);
        charger.setChargingStation(chargingStation);
        chargingProcess.setCustomer(customer);
        chargingProcess.setChargingStation(chargingStation);
        chargingProcess.setCharger(charger);
        chargingProcess.setEndTime(end);
        chargingProcess.calculateTotalPrice();
        invoice = new Invoice(chargingProcess.calculateTotalPrice(), chargingProcess);
    }

    @When("I view the invoice")
    public void iViewTheInvoice() {
        invoice.printInvoice();
    }

    @Then("I see that I charged {d}kW")
    public void iSeeThatIChargedKW(int arg0) {
    }

    @And("I see the rate for {string} charging is {string}€ per kWh")
    public void iSeeTheRateForChargingIs€PerKWh(String arg0, String arg1) {
    }

    @And("I see the total cost for energy consumed is {string}€")
    public void iSeeTheTotalCostForEnergyConsumedIs€(String arg0) {
    }



    @And("I see that the amount I was charged is {string}€")
    public void iSeeThatTheAmountIWasChargedIs€(String arg0) {
    }


    @And("I see the charging station name {string}")
    public void iSeeTheChargingStationName(String arg0) {
    }

    @And("I see the location {string}")
    public void iSeeTheLocation(String arg0) {
    }

    @And("I see that the charging process started at {string}")
    public void iSeeThatTheChargingProcessStartedAt(String arg0) {
    }

    @And("I see that the charging process ended at {string}")
    public void iSeeThatTheChargingProcessEndedAt(String arg0) {
    }

    @And("I see that the duration of the charging session was {string} minutes")
    public void iSeeThatTheDurationOfTheChargingSessionWasMinutes(String arg0) {
    }

    @Then("I see that I charged {string}kW")
    public void iSeeThatIChargedKW(String arg0) {
    }

    @And("I see the rate for DC charging is {string}€ per kWh")
    public void iSeeTheRateForDCChargingIs€PerKWh(String arg0) {
    }

    @And("I see that the Standing Fee I was charged is {string}€")
    public void iSeeThatTheStandingFeeIWasChargedIs€(String arg0) {
    }



}
