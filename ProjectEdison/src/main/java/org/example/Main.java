package org.example;

public class Main {
    public static void main(String[] args) {
        // Erstellen der NetworkList-Instanz
        NetworkList networkList = NetworkList.getInstance();

        // Hinzufügen der Beispiel-Ladestationen
        ChargingStation wienCharging = new ChargingStation("WienCharging", "Vienna, Austria", 0.25, 0.40);
        ChargingStation grazCharging = new ChargingStation("GrazCharging", "Graz, Austria", 0.30, 0.38);
        ChargingStation linzCharging = new ChargingStation("LinzCharging", "Linz, Austria", 0.28, 0.43);

        System.out.println(networkList.getStationsSortedByPrice(true));
        System.out.println(networkList.getPriceOverview());

    }
}
