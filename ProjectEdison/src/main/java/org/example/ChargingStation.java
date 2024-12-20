package org.example;

public class ChargingStation {
    private String location;
    private String CsName;
    private double priceAC;
    private double priceDC;
    private double standingFee = 0.5;


    public ChargingStation(String CsName, String location, double priceAC, double priceDC) {
        this.CsName = CsName;
        this.location = location;
        this.priceAC = priceAC;
        this.priceDC = priceDC;
        NetworkList.getInstance().addChargingStation(this);

    }
    public ChargingStation() {
    }


    //GETTER AND SETTER

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCsName() {
        return CsName;
    }

    public void setCsName(String csName) {
        this.CsName = csName;
    }


    public double getPriceAC() {
        return priceAC;
    }

    public void setPriceAC(double priceAC) {
        this.priceAC = priceAC;
    }

    public double getPriceDC() {
        return priceDC;
    }

    public void setPriceDC(double priceDC) {
        this.priceDC = priceDC;
    }

    public void setStandingFee(double StandingFee) {
        this.standingFee = StandingFee;
    }

    public double getStandingFee() {
        return standingFee;
    }

    public void settime(String arg0) {
    }

    public void endtime(String arg0) {
    }
}
