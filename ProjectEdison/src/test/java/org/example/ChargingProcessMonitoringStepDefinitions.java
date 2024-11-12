package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChargingProcessMonitoringStepDefinitions {

    private String customerName;
    private int credit;
    private int maxBatteryCapacity;
    private int currentCapacity;

    @Given("My Customer Name is {string}")
    public void myCustomerNameIs(String arg0) {
       this.customerName = arg0;
    }

    @And("my credit is {int} €")
    public void myCreditIs€(int arg0) {
        this.credit = arg0;
    }

    @And("my vehicle has a maximum Battery capacity of {int} kW")
    public void myVehicleHasAMaximumBatteryCapacityOfKW(int arg0) {
        this.maxBatteryCapacity = arg0;
    }

    @And("the current capacity is at {int} kW")
    public void theCurrentCapacityIsAtKW(int arg0) {
        this.currentCapacity = arg0;
    }

    @And("I was at the charging Station {string}")
    public void iWasAtTheChargingStation(String arg0) {
        ChargingStation chargingStation = new ChargingStation(arg0, "", 0.0, 0.0);
    }

    @And("the station is located at the address {string}")
    public void theStationIsLocatedAtTheAddress(String arg0) {
        ChargingStation chargingStation = new ChargingStation("", arg0, 0.0, 0.0);
    }

    @And("the Standing fee is {double}€ per minute")
    public void theStandingFeeIs€PerMinute(double arg0) {
        ChargingStation chargingStation = new ChargingStation("", "", 0.0, 0.0);
        double standingFee = 0.50;
        chargingStation.setStandingFee(standingFee);
    }

    @And("the charging process started at {string}")
    public void theChargingProcessStartedAt(String arg0) {
        ChargingStation chargingStation = new ChargingStation("", "", 0.0, 0.0);
        chargingStation.settime(arg0);
    }

    @And("the charging process ended at {string}")
    public void theChargingProcessEndedAt(String arg0) {
        ChargingStation chargingStation = new ChargingStation("", "", 0.0, 0.0);
        chargingStation.endtime(arg0);
    }

    @When("I view the invoice")
    public void iViewTheInvoice() {
    }

    @Then("I see that I charged {int}kW")
    public void iSeeThatIChargedKW(int arg0) {
    }

    @And("I see the rate for {string} charging is {string}€ per kWh")
    public void iSeeTheRateForChargingIs€PerKWh(String arg0, String arg1) {
    }

    @And("I see the total cost for energy consumed is {string}€")
    public void iSeeTheTotalCostForEnergyConsumedIs€(String arg0) {
    }

    @And("I see that no standing fee was applied")
    public void iSeeThatNoStandingFeeWasApplied() {
    }

    @And("I see that the amount I was charged is {string}€")
    public void iSeeThatTheAmountIWasChargedIs€(String arg0) {
    }

    @And("the remaining credit is {string}€")
    public void theRemainingCreditIs€(String arg0) {
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
