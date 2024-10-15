package org.example;

public class Charger {

    private int ID;
    private ChargingStation chargingStation;
    private Enum ChargingMethod;
    private Enum ChargingStatus;

public Charger (){}
    public Charger(int ID, ChargingStation chargingStation, ChargingMethod ChargingMethod, ChargingStatus ChargingStatus) {
        this.ID = ID;
        this.chargingStation = chargingStation;
        this.ChargingMethod = ChargingMethod;
        this.ChargingStatus = ChargingStatus;
    }

    public Charger (int ID, ChargingStation chargingStation, ChargingMethod ChargingMethod){
        this.ID = ID;
        this.chargingStation = chargingStation;
        this.ChargingMethod = ChargingMethod;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }



    public ChargingStation getChargingStation() {
        return chargingStation;
    }


    public void setChargingStation(ChargingStation chargingStation) {
        this.chargingStation = chargingStation;
    }

    public Enum getChargingMethod() {
        return ChargingMethod;
    }

    public void setChargingMethod(ChargingMethod ChargingMethod) {
        this.ChargingMethod = ChargingMethod;
    }

    public Enum getChargingStatus() {
        return ChargingStatus;
    }

    public void setChargingStatus(ChargingStatus ChragingStatus) {
        this.ChargingStatus = ChragingStatus;
    }




}
