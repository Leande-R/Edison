package org.example;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;
import java.util.LinkedList;

public class CheckChargingStationPricesStepDefinitions {
    private ChargingStation chargingStation;
  private LinkedList<ChargingStation> chargingStationsPricelist;




    @Given("I plan to charge my vehicle")
    public void iPlanToChargeMyVehicle() {
    }


    @When("I check the list of the charging stations {string}, {string}, {string}")
    public void iCheckTheListOfTheChargingStations(String CsName1, String CsName2, String CsName3) {
        chargingStationsPricelist = new LinkedList<>();
        chargingStationsPricelist.add(new ChargingStation(CsName1, null, 1, 2));
        chargingStationsPricelist.add(new ChargingStation(CsName2, null, 4, 7));
        chargingStationsPricelist.add(new ChargingStation(CsName3, null, 3, 5));



    }

    @Then("I can see the prices of the charging stations")
    public void iCanSeeThePricesOfTheChargingStations() {
        for (ChargingStation station : chargingStationsPricelist) {
            System.out.println("Charging Station: " + station.getCsName());
            System.out.println("Price AC: " + station.getPriceAC() + " Euros per minute");
            System.out.println("Price DC: " + station.getPriceDC() + " Euros per minute");
            System.out.println("-----------------------------");
        }
    }
}
