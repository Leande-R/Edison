package org.example;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class AssignChargerStatusStepdefinitions {


    Charger charger;


    @ParameterType("IN_OPERATION_FREE|OCCUPIED|OUT_OF_ORDER")
    public ChargingStatus status(String status) {
        return ChargingStatus.valueOf(status);
    }

    @Given("I want to assign a different charger status to my charger")
    public void iWantToAssignADifferentChargerStatusToMyCharger() {
            charger = new Charger();
    }

    @When("I enter {status} into the charger status description field")
    public void iEnterOUT_OF_ORDERIntoTheChargerStatusDescriptionField(ChargingStatus status) {
        charger.setChargingStatus(status);

    }

    @Then("the charger status {status} is assigned to the charger")
    public void theChargerStatusIsAssignedToTheCharger(ChargingStatus status) {
        assertEquals(ChargingStatus.OUT_OF_ORDER, charger.getChargingStatus());

    }




}
