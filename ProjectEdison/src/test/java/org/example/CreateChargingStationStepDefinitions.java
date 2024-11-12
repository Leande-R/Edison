package org.example;


import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChargingStationStepDefinitions {
    @Given("I want to create a new Charging Station in the System")
    public void iWantToCreateANewChargingStationInTheSystem() {
        // Implementation here
    }

    @And("the address of the Charging Station is {string}")
    public void theAddressOfTheChargingStationIs(String address) {
        // Implementation here
        ChargingStation chargingStation = new ChargingStation("", address, 0.0, 0.0);
    }

    @When("I enter {string} into the Location field")
    public void iEnterIntoTheLocationField(String arg0) {
        ChargingStation chargingStation = new ChargingStation("", arg0, 0.0, 0.0);
    }

    @And("I enter the name {string} into the name field")
    public void iEnterTheNameIntoTheNameField(String arg0) {
        ChargingStation chargingStation = new ChargingStation(arg0, "", 0.0, 0.0);
    }

    @And("I set the price for {string} charging to {string}€ per minute")
    public void iSetThePriceForChargingTo€PerMinute(String arg0, String arg1) {
        ChargingStation chargingStation = new ChargingStation("", "", Double.parseDouble(arg1), 0.0);
    }

    @Then("I have successfully created a new Charging Station in {string} with the name {string}")
    public void iHaveSuccessfullyCreatedANewChargingStationInWithTheName(String arg0, String arg1) {
        ChargingStation chargingStation = new ChargingStation(arg1, arg0, 0.0, 0.0);
    }

    @And("I have successfully created a new price list for the Charging Station {string}")
    public void iHaveSuccessfullyCreatedANewPriceListForTheChargingStation(String arg0) {
        ChargingStation chargingStation = new ChargingStation("", arg0, 0.0, 0.0);
    }

    @And("I have set the price for {string} to {string}€ per minute")
    public void iHaveSetThePriceForTo€PerMinute(String arg0, String arg1) {

        ChargingStation chargingStation = new ChargingStation("", "", 0.0, 0.0);
        if (arg0.equals("AC")) {
            chargingStation.setPriceAC(Double.parseDouble(arg1));
        } else if (arg0.equals("DC")) {
            chargingStation.setPriceDC(Double.parseDouble(arg1));
        }

    }
}
