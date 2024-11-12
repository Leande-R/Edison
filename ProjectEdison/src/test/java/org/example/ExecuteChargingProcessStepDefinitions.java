
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

    @Given("I want to charge my vehicle at the Charging Station {string}")
    public void iWantToChargeMyVehicleAtTheChargingStation(String arg0) {
        this.chargingStation = new ChargingStation(arg0, "", 0.0, 0.0);
    }

    @And("I already have an account with the ID {string}")
    public void iAlreadyHaveAnAccountWithTheID(String arg0) {
        this.customer = new Customer(Integer.parseInt(arg0), "", "", "", 0);
    }

    @And("my credit is {int}€")
    public void myCreditIs€(int arg0) {
        this.customer.setCredit(arg0);
    }

    @And("I want to charge my vehicle for {int} minutes")
    public void iWantToChargeMyVehicleForMinutes(int arg0) {
        this.chargingProcess = new ChargingProcess(this.customer, this.charger, LocalDateTime.now(), null);
    }

    @And("I want to charge my vehicle with AC")
    public void iWantToChargeMyVehicleWithAC() {
        this.charger = new Charger(0, this.chargingStation, ChargingMethod.AC);
    }

    @When("I select the Charger with the ID {int} , at the Charging Station {string}")
    public void iSelectTheChargerWithTheIDAtTheChargingStation(int ID, String Location) {
        this.charger = new Charger(ID, this.chargingStation, ChargingMethod.AC);
    }

    @And("the charging process ends at {string}")
    public void theChargingProcessEndsAt(String arg0) {
        this.chargingProcess.setEndTime(LocalDateTime.parse(arg0, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Then("the charging process took {int} minutes")
    public void theChargingProcessTookMinutes(int arg0) {
        assertEquals(arg0, this.chargingProcess.getDurationMinutes());
    }

    @And("the charging process starts at {string}")
    public void theChargingProcessStartsAt(String arg0) {
        this.chargingProcess.setStartTime(LocalDateTime.parse(arg0, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @And("I am charged {int} Euros")
    public void iAmChargedEuros(int arg0) {
        assertEquals(arg0, this.customer.getCredit());
    }

    @And("the price for AC at {string} is {double}€ per minute")
    public void thePriceForACAtIsPerMinute(String stationName, double price) {
        if (this.chargingStation.getCsName().equals(stationName)) {
            this.chargingStation.setPriceAC(price);
        }
    }


    @Then("the charging process cannot start before the current time")
    public void theChargingProcessCannotStartBeforeTheCurrentTime() {
        try {
            if (this.chargingProcess.getStartTime().isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("Charging process cannot start before the current time.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    @And("I am not charged")
    public void iAmNotCharged() {
    }
}
