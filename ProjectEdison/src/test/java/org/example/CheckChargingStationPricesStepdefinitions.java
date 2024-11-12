package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckChargingStationPricesStepdefinitions {
    @Given("The Charging Stations {string}, {string} and {string} are already created")
    public void theChargingStationsAndAreAlreadyCreated(String arg0, String arg1, String arg2) {
        ChargingStation chargingStation1 = new ChargingStation(arg0, "", 0.0, 0.0);
        ChargingStation chargingStation2 = new ChargingStation(arg1, "", 0.0, 0.0);
        ChargingStation chargingStation3 = new ChargingStation(arg2, "", 0.0, 0.0);
    }

    @And("the Standing Fee is {string}€ per minute on every Charging Station")
    public void theStandingFeeIs€PerMinuteOnEveryChargingStation(String arg0) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            station.setStandingFee(Double.parseDouble(arg0));
        }
    }

    @And("the Price for {string} at {string} is {string}€ per KwH")
    public void thePriceForAtIs€PerKwH(String arg0, String arg1, String arg2) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            if (station.getCsName().equals(arg1)) {
                if (arg0.equals("AC")) {
                    station.setPriceAC(Double.parseDouble(arg2));
                } else if (arg0.equals("DC")) {
                    station.setPriceDC(Double.parseDouble(arg2));
                }
            }
        }
    }

    @When("I open the Pricelists of the three Stations to compare them")
    public void iOpenThePricelistsOfTheStationsToCompareThem(int arg0) {
        this.theChargingStationsAndAreAlreadyCreated("Station1", "Station2", "Station3");
    }

    @Then("I see that the Standing Fee on all Charging Stations is {string}€ per minute")
    public void iSeeThatTheStandingFeeOnAllChargingStationsIs€PerMinute(String arg0) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            assertEquals(Double.parseDouble(arg0), station.getStandingFee());
        }
    }

    @And("I see that the Price for {string} at {string} is {string}€ per KwH")
    public void iSeeThatThePriceForAtIs€PerKwH(String arg0, String arg1, String arg2) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            if (station.getCsName().equals(arg1)) {
                if (arg0.equals("AC")) {
                    assertEquals(Double.parseDouble(arg2), station.getPriceAC());
                } else if (arg0.equals("DC")) {
                    assertEquals(Double.parseDouble(arg2), station.getPriceDC());
                }
            }
        }
    }
}
