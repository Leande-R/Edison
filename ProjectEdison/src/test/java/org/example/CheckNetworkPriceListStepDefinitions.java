package org.example;
import io.cucumber.java.en.*;
import java.util.LinkedList;

public class CheckNetworkPriceListStepDefinitions {
    private ChargingStation chargingStation;
  private LinkedList<ChargingStation> NetworkPricelist;




    @Given("I plan to charge my vehicle")
    public void iPlanToChargeMyVehicle() {
    }


    @When("I check the Network-Pricelist of the charging stations {string}, {string}, {string}")
    public void iCheckTheNetworkPricelistOfTheChargingStations(String CsName1, String CsName2, String CsName3) {
        NetworkPricelist = new LinkedList<>();
        NetworkPricelist.add(new ChargingStation(CsName1, null, 1, 2));
        NetworkPricelist.add(new ChargingStation(CsName2, null, 4, 7));
        NetworkPricelist.add(new ChargingStation(CsName3, null, 3, 5));
    }

    @Then("I can see the prices of the charging stations")
    public void iCanSeeThePricesOfTheChargingStations() {
        for (ChargingStation station : NetworkPricelist) {
            System.out.println("Charging Station: " + station.getCsName());
            System.out.println("Price AC: " + station.getPriceAC() + " Euros per minute");
            System.out.println("Price DC: " + station.getPriceDC() + " Euros per minute");
            System.out.println("-----------------------------");
        }
    }


}
