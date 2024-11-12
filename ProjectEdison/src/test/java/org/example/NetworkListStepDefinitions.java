package org.example;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class NetworkListStepDefinitions {
    private NetworkList networkList = NetworkList.getInstance();

    @Given("the network contains the charging stations {string}, {string}, and {string}")
    public void theNetworkContainsChargingStations(String station1, String station2, String station3) {
        // Create and add the charging stations
        ChargingStation stationA = new ChargingStation(station1, "Vienna, Austria", 0.25, 0.40);
        ChargingStation stationB = new ChargingStation(station2, "Graz, Austria", 0.30, 0.38);
        ChargingStation stationC = new ChargingStation(station3, "Linz, Austria", 0.28, 0.43);

        networkList.addChargingStation(stationA);
        networkList.addChargingStation(stationB);
        networkList.addChargingStation(stationC);
    }

    @When("I view the list of charging stations")
    public void iViewTheListOfChargingStations() {
    }

    @Then("the stations should be displayed in the following order:")
    public void theStationsShouldBeDisplayedInTheFollowingOrder(List<String> stationNames) {
        List<ChargingStation> stations = networkList.getChargingStations();
        for (int i = 0; i < stationNames.size(); i++) {
            Assertions.assertEquals(stationNames.get(i), stations.get(i).getCsName(),
                    "Station at position " + (i + 1) + " should be " + stationNames.get(i));
        }
    }

    @When("I sort the stations by AC price")
    public void iSortTheStationsByACPrice() {
        networkList.getStationsSortedByPrice(true);
    }

    @Then("the stations should be displayed in the following order by AC price:")
    public void theStationsShouldBeDisplayedInTheFollowingOrderByACPrice(List<String> stationNames) {
        List<ChargingStation> sortedStations = networkList.getChargingStations();

        for (int i = 0; i < stationNames.size(); i++) {
            Assertions.assertEquals(stationNames.get(i), sortedStations.get(i).getCsName(),
                    "Station at position " + (i + 1) + " should be " + stationNames.get(i));
        }
    }


    @When("I update the AC price for {string} to {double}")
    public void iUpdateTheACPriceForStation(String stationName, double newACPrice) {
        networkList.updatePriceAC(stationName, newACPrice);
    }

    @When("I update the DC price for {string} to {double}")
    public void iUpdateTheDCPriceForStation(String stationName, double newDCPrice) {
        networkList.updatePriceDC(stationName, newDCPrice);
    }

    @Then("the updated prices should be:")
    public void theUpdatedPricesShouldBe(List<List<String>> priceData) {
        List<ChargingStation> stations = networkList.getChargingStations();
        for (int i = 0; i < priceData.size(); i++) {
            String stationName = priceData.get(i).get(0);
            double expectedACPrice = Double.parseDouble(priceData.get(i).get(1));
            double expectedDCPrice = Double.parseDouble(priceData.get(i).get(2));

            ChargingStation station = stations.stream()
                    .filter(cs -> cs.getCsName().equals(stationName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Charging station not found"));

            Assertions.assertEquals(expectedACPrice, station.getPriceAC(),
                    "AC price for " + stationName + " should be " + expectedACPrice);
            Assertions.assertEquals(expectedDCPrice, station.getPriceDC(),
                    "DC price for " + stationName + " should be " + expectedDCPrice);
        }
    }

    @When("I sort the stations by DC price")
    public void iSortTheStationsByDCPrice() {
        networkList.getStationsSortedByPrice(false);
    }

    @Then("the stations should be displayed in the following order by DC price:")
    public void theStationsShouldBeDisplayedInTheFollowingOrderByDCPrice(List<String> stationNames) {
        List<ChargingStation> sortedStations = networkList.getChargingStations();
        for (int i = 0; i < stationNames.size(); i++) {
            Assertions.assertEquals(stationNames.get(i), sortedStations.get(i).getCsName(),
                    "Station at position " + (i + 1) + " should be " + stationNames.get(i));
        }
    }
}
