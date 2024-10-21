package org.example;

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
}