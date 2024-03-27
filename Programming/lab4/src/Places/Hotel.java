package Places;

import java.util.ArrayList;

public class Hotel extends PlaceContainPlaces {
    private double priceForOneNight = 0;
    public Hotel(){
        super("гостиница");
    }
    public Hotel(String name) {
        super(name);
    }
    public Hotel(String name, double priceForOneNight){
        super(name);
        this.priceForOneNight = priceForOneNight;
    }
    public void setPriceForOneNight(double priceForOneNight){
        this.priceForOneNight = priceForOneNight;
    }
    public double getPriceForOneNight(){
        return priceForOneNight;
    }
    public double getTotalPrice(int nightsCount){
        return nightsCount * priceForOneNight;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Hotel) otherObject;
        final double EPS = 0.0001;
        return Math.abs(priceForOneNight - other.getPriceForOneNight()) < EPS;
    }
    @Override
    public String toString(){
        return super.toString() + "[priceForOneNight=" + priceForOneNight + "]";
    }
}
