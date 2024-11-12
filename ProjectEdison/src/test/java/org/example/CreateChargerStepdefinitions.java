package org.example;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChargerStepdefinitions {

    private Charger charger = new Charger();
    private ChargingStation chargingStation;

    @ParameterType("AC|DC")
    public ChargingMethod method(String method) {
        return ChargingMethod.valueOf(method);
    }


    @Given("I already created a charging station in Fürstenfeld called {string}")
    public void iAlreadyCreatedAChargingStationInFürstenfeldCalled(String givenLocation) {
        this.chargingStation = new ChargingStation("Einsteingasse 1, 8280", givenLocation, 0.25, 0.35);
    }


    @When("I assign the charger to the charging station {string}")
    public void iAssignTheChargerToTheChargingStation(String givenLocation) {
        if (chargingStation.getLocation().equals(givenLocation)) {
            charger.setChargingStation(chargingStation);
        } else {
            throw new IllegalArgumentException("Charging Station not found");
        }
    }


    @And("I enter the ID {int}")
    public void iEnterTheID(int id) {
        charger.setID(id);
    }


    @And("I select the Charging Method as {string}")
    public void iSelectTheChargingMethodAs(String method) {
        ChargingMethod cMethod = ChargingMethod.valueOf(method);
        charger.setChargingMethod(cMethod);
    }


    @Then("a new Charger with the ID {int} is created")
    public void aNewChargerWithTheIDIsCreated(int identification) {
        assertEquals(identification, charger.getID());
    }


    @And("it has the Charging Method {string}")
    public void itHasTheChargingMethod(String chargingMethodString) {
        ChargingMethod chargingMethod = ChargingMethod.valueOf(chargingMethodString);
        assertEquals(chargingMethod, charger.getChargingMethod());
    }


    @And("it's assigned to the Charging Station {string}")
    public void itSAssignedToTheChargingStation(String givenLocation) {
        assertEquals(givenLocation, charger.getChargingStation().getLocation());
    }


}