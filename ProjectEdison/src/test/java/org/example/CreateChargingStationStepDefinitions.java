package org.example;


import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChargingStationStepDefinitions {

    private ChargingStation chargingStation;

    @Given("i want to create a new Charging Station in the System")
    public void iWantToCreateANewChargingStationInTheSystem() {
        chargingStation = new ChargingStation(null, null, 0, 0);
    }

    @When("i enter {string} into the Location field")
    public void iEnterIntoTheLocationField(String location) {
        chargingStation.setLocation(location);
    }




    @And("i enter the name {string} into the name field")
    public void iEnterTheNameIntoTheNameField(String name) {
       chargingStation.setCsName(name);
    }

    @And("i set the price for AC charging to {double} per kWh")
    public void iSetThePriceForACChargingToPerKWh(double priceAC) {
        chargingStation.setPriceAC(priceAC);

    }

    @And("i set the price for DC charging to {double} per kWh")
    public void iSetThePriceForDCChargingToPerKWh(double priceDC) {
        chargingStation.setPriceDC(priceDC);
    }

    @Then("i have sucessfully created a new Charging Station in {string} with the name {string} and the AC-price  {double} and the DC-Price {double}")
    public void iHaveSucessfullyCreatedANewChargingStationInFürstendfeld(String location, String name, double priceAC, double priceDC) {
        assertEquals(location, chargingStation.getLocation());
        assertEquals(name, chargingStation.getCsName());
        assertEquals(priceAC, chargingStation.getPriceAC());
        assertEquals(priceDC, chargingStation.getPriceDC());

    }
}
