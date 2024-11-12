package org.example;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class NetworkList {
    private static NetworkList instance;
    private List<ChargingStation> chargingStations;

    private NetworkList() {
        chargingStations = new LinkedList<>();
    }

    public static synchronized NetworkList getInstance() {
        if (instance == null) {
            instance = new NetworkList();
        }
        return instance;
    }

    public void addChargingStation(ChargingStation station) {
        chargingStations.add(station);
    }

    public List<ChargingStation> getChargingStations() {
        return chargingStations;
    }

    public List<ChargingStation> getStationsSortedByPrice(boolean forAC) {
        chargingStations.sort(Comparator.comparingDouble(
                station -> forAC ? station.getPriceAC() : station.getPriceDC()));
        return chargingStations;
    }

    public void updatePriceAC(String stationName, double newPriceAC) {
        for (ChargingStation station : chargingStations) {
            if (station.getCsName().equals(stationName)) {
                station.setPriceAC(newPriceAC);
                return;
            }
        }
        throw new IllegalArgumentException("Charging Station with name " + stationName + " not found.");
    }

    public void updatePriceDC(String stationName, double newPriceDC) {
        for (ChargingStation station : chargingStations) {
            if (station.getCsName().equals(stationName)) {
                station.setPriceDC(newPriceDC);
                return;
            }
        }
        throw new IllegalArgumentException("Charging Station with name " + stationName + " not found.");
    }

    public String getPriceOverview() {
        StringBuilder sb = new StringBuilder();
        for (ChargingStation station : chargingStations) {
            sb.append(String.format("Station: %s, Location: %s, AC Price: %.2f, DC Price: %.2f\n",
                    station.getCsName(), station.getLocation(), station.getPriceAC(), station.getPriceDC()));
        }
        return sb.toString();
    }


    public void updateStandingFee(String csName, double newStandingFee) {
        for (ChargingStation station : chargingStations) {
            if (station.getCsName().equals(csName)) {
                station.setStandingFee(newStandingFee);
                break;
            }
        }
    }
}