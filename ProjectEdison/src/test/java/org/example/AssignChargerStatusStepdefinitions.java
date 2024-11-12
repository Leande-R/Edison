package org.example;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

    @When("My Charger has the Status {status}")
    public void myChargerHasTheStatusIN_OPERATION_FREE(ChargingStatus status) {
        charger.setChargingStatus(status);
    }
    @And("I want to change its Status to {status}")
    public void iWantToChangeItsStatusToOUT_OF_ORDER(ChargingStatus status) {
        charger.setChargingStatus(status);
    }
    @Then("the charger status {status} is assigned to the charger")
    public void theChargerStatusIsAssignedToTheCharger(ChargingStatus status) {
        assertEquals(status, charger.getChargingStatus());

    }
    @And("no longer {status}")
    public void noLongerIN_OPERATION_FREE(ChargingStatus status) {
        assertNotEquals(status, charger.getChargingStatus());
    }


}
