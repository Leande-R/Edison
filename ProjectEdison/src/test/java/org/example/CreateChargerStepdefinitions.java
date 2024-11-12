package org.example;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChargerStepdefinitions {



    private Charger charger;
    private ChargingStation chargingStation;


    @ParameterType("AC|DC")
    public ChargingMethod method(String method) {
        return ChargingMethod.valueOf(method);
    }

    @Given("I created a new charging station in Fürstenfeld")
    public void iCreatedANewChargingStationInFürstenfeld() {
        chargingStation = new ChargingStation("Einsteingasse 1, 8280", "Fürstenfeld Charging", 0.25, 0.35);
    }


    @Given("I want to create a new charger")
    public void iWantToCreateANewCharger() {
        charger = new Charger( 0, null, null, null);
    }



    @When("I assign the charger to the charging station {string}")
    public void iAssignTheChargerToTheChargingStation(String location) {
        charger.setChargingStation(chargingStation);
    }

    @And("I enter the ID {int}")
    public void iEnterTheID(int id) {
        charger.setID(id);
    }

    @And("I select the Charging Method as {method}")
    public void iSelectTheChargingMethodAs(ChargingMethod method) {
        charger.setChargingMethod(method);

    }

   /* @Then("a new Charger with the ID {int} assigned to the Charging Station {String} and the Charging Method {method} is created")
    public void aNewChargerIsCreated(int id, String chargingstation, ChargingMethod method) {
        assertEquals(id, charger.getID());
        assertEquals(chargingstation, charger.getChargingStation().getLocation());
        assertEquals(method, charger.getChargingMethod());

    }*/

    @Then("a new Charger with the ID {int} assigned to the Charging Station {string} is created")
    public void aNewChargerWithTheIDAssignedToTheChargingStationAndTheChargingMethodDCIsCreated(int id, String chargingstation) {
        assertEquals(id, charger.getID());
        assertEquals(chargingstation, charger.getChargingStation().getLocation());
    }



}