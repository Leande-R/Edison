package org.example;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateChargingStationPriceListStepDefinitions {

    private LinkedList<ChargingStation> chargingStationsPricelist;

    @ParameterType("Fürstenfeld Charging|Graz Charging|Wien Charging")
    public ChargingStation location(String location) {
        switch (location) {
            case "Fürstenfeld Charging":
                return new ChargingStation("Fürstenfeld Charging", null, 1, 2);
            case "Graz Charging":
                return new ChargingStation("Graz Charging", null, 4, 7);
            case "Wien Charging":
                return new ChargingStation("Wien Charging", null, 3, 5);
            default:
                throw new IllegalArgumentException("Unknown location: " + location);
        }
    }

    @When("I want to create a new Charging Station price list for my Charging Stations")
    public void iWantToCreateANewChargingStationPriceListForMyChargingStations() {
        chargingStationsPricelist = new LinkedList<>();
    }

    @And("I add my Charging Stations {location}, {location}, {location} to the price list")
    public void iAddMyChargingStationsFürstenfeldChargingGrazChargingAndWienChargingToThePriceList(ChargingStation location1, ChargingStation location2, ChargingStation location3) {
        chargingStationsPricelist.add(location1);
        chargingStationsPricelist.add(location2);
        chargingStationsPricelist.add(location3);
    }

    @Then("a new charging price list is created")
    public void aNewChargingPriceListIsCreated() {
    }

    }