package org.example;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChargingProcessMonitoringStepDefinitions {

    private Invoice invoice;
    private ChargingProcess chargingProcess;
    private Customer customer;
    private ChargingStation chargingStation;
    private Charger charger;

    @Given("My Name is {string} , {string} , CustomerID {int} , my mail is {string}, my credit is {int} Euro I just charged my vehicle")
    public void myNameIsCustomerIDMyMailIsMyCreditIsEuroIJustChargedMyVehicle(String firstname, String lastname, int id, String mail, int credit) {
        this.customer = new Customer(id, firstname, lastname, mail, credit);

    }

    @When("I was at the charging Station {string}, at the address {string}, with a ACPrice of {double} Euro per minute , a DCPrice of {double} Euro per minute")
    public void iWasAtTheChargingStationAtTheAddressWithAACPriceOfEuroPerMinuteADCPriceOfEuroPerMinute(String CsName, String location, double PriceAC, double PriceDC) {
        this.chargingStation = new ChargingStation(CsName, location, PriceAC, PriceDC);
    }


    @And("I selected the charger with the ID {int} , at the chargingstation {string} , the selected Charging Method is {method}")
    public void iSelectedTheChargerWithTheIDAtTheChargingstationTheSelectedChargingMethodIsAC(int id, String chargingStationName, ChargingMethod method) {
        System.out.println("Expected Charging Station: " + this.chargingStation.getCsName());
        System.out.println("Provided Charging Station: " + chargingStationName);

        if (!chargingStationName.equals(this.chargingStation.getCsName())) {
            throw new IllegalArgumentException("Charging station name does not match the previously defined charging station.");
        }
        this.charger = new Charger(id, this.chargingStation, method);
    }


    @And("the charging process started at {string}")
    public void theChargingProcessStartedAt(String startTime) {
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.chargingProcess = new ChargingProcess(this.customer, this.charger, start, null);

    }


    @Then("the charging process was executed , took {long} minutes")
    public void theChargingProcessWasExecutedTookMinutes(long durationMinutes) {
        chargingProcess.chargeVehicle(chargingProcess.getStartTime(), durationMinutes);
chargingProcess.setEndTime(chargingProcess.getStartTime().plusMinutes(durationMinutes));
    }

    @And("I was charged {double} Euros")
    public void iWasChargedEuros(double expectedCharge) {
        assertEquals(expectedCharge, this.customer.getCredit());

    }

    @Then("I can view the invoice for the charging process")
    public void iCanViewTheInvoiceForTheChargingProcess() {
        invoice = new Invoice(chargingProcess.calculateTotalPrice(), chargingProcess);
        assertEquals(chargingProcess.calculateTotalPrice(), invoice.getPrice());

    }
}
