package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckChargingStationPricesStepdefinitions {

    @Given("The Charging Stations {string}, {string} and {string} are already created")
    public void theChargingStationsAndAreAlreadyCreated(String station1Name, String station2Name, String station3Name) {
        ChargingStation chargingStation1 = new ChargingStation(station1Name, "", 0.0, 0.0);
        ChargingStation chargingStation2 = new ChargingStation(station2Name, "", 0.0, 0.0);
        ChargingStation chargingStation3 = new ChargingStation(station3Name, "", 0.0, 0.0);

        NetworkList networkList = NetworkList.getInstance();
        networkList.addChargingStation(chargingStation1);
        networkList.addChargingStation(chargingStation2);
        networkList.addChargingStation(chargingStation3);
    }

    @And("the Standing Fee is {string}€ per minute on every Charging Station")
    public void theStandingFeeIs€PerMinuteOnEveryChargingStation(String standingFee) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            station.setStandingFee(Double.parseDouble(standingFee));
        }
    }

    @And("the Price for {string} at {string} is {string}€ per KwH")
    public void thePriceForAtIs€PerKwH(String priceType, String stationName, String price) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            if (station.getCsName().equals(stationName)) {
                if (priceType.equals("AC")) {
                    station.setPriceAC(Double.parseDouble(price));
                } else if (priceType.equals("DC")) {
                    station.setPriceDC(Double.parseDouble(price));
                }
            }
        }
    }

    @When("I open the Pricelists of the three Stations to compare them")
    public void iOpenThePricelistsOfTheStationsToCompareThem() {
    }

    @Then("I see that the Standing Fee on all Charging Stations is {string}€ per minute")
    public void iSeeThatTheStandingFeeOnAllChargingStationsIs€PerMinute(String standingFee) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            assertEquals(Double.parseDouble(standingFee), station.getStandingFee(),
                    "Standing fee mismatch for station " + station.getCsName());
        }
    }

    @And("I see that the Price for {string} at {string} is {string}€ per KwH")
    public void iSeeThatThePriceForAtIs€PerKwH(String priceType, String stationName, String price) {
        for (ChargingStation station : NetworkList.getInstance().getChargingStations()) {
            if (station.getCsName().equals(stationName)) {
                if (priceType.equals("AC")) {
                    assertEquals(Double.parseDouble(price), station.getPriceAC(),
                            "AC price mismatch for " + stationName);
                } else if (priceType.equals("DC")) {
                    assertEquals(Double.parseDouble(price), station.getPriceDC(),
                            "DC price mismatch for " + stationName);
                }
            }
        }
    }
}
