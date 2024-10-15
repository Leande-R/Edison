package org.example;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExecuteChargingProcessStepDefinitions {

    private Customer customer;
    private ChargingStation chargingStation;
    private Charger charger;
    private ChargingProcess chargingProcess;



    @Given("My Name is {string} , {string} , CustomerID {int} , my mail is {string}, my credit is {int} Euro I want to charge my vehicle")
    public void myNameIsCustomerIDMyMailIsMyCreditIsEuroIWantToChargeMyVehicle(String firstname, String lastname, int id, String mail, int credit) {
        this.customer = new Customer(id, firstname, lastname, mail, credit);
    }

    @When("I am at the chargingstation {string}, at the address {string}, with a ACPrice of {double} Euro per minute , a DCPrice of {double} Euro per minute")
    public void iAmAtTheChargingstationAtTheAddressWithAACPriceOfEuroPerMinuteADCPriceOfEuroPerMinute(String CsName, String location, double PriceAC, double PriceDC) {
        this.chargingStation = new ChargingStation(CsName, location, PriceAC, PriceDC);
    }

    @And("I select the charger with the ID {int} , at the chargingstation {string} , the selected Charging Method is {method}")
    public void iSelectTheChargerWithTheIDAtTheChargingstationTheSelectedChargingMethodIs(int id, String chargingStationName, ChargingMethod method) {
        System.out.println("Expected Charging Station: " + this.chargingStation.getCsName());
        System.out.println("Provided Charging Station: " + chargingStationName);

        if (!chargingStationName.equals(this.chargingStation.getCsName())) {
            throw new IllegalArgumentException("Charging station name does not match the previously defined charging station.");
        }
        this.charger = new Charger(id, this.chargingStation, method);
    }

    @And("the charging process starts at {string}")
    public void theChargingProcessStartsAt(String startTime) {
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.chargingProcess = new ChargingProcess(this.customer, this.charger, start, null);
    }





    @Then("the charging process is executed , takes {long} minutes")
    public void theChargingProcessIsExecutedTakesMinutes(long durationMinutes) {
        chargingProcess.chargeVehicle(chargingProcess.getStartTime(), durationMinutes);
    }




    @Then("I am charged {double} Euros")
    public void iAmCharged(double expectedCharge) {
        assertEquals(expectedCharge, this.customer.getCredit());
    }
}