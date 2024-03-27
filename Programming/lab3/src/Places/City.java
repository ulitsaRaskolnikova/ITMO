package Places;

import java.util.ArrayList;

public class City extends Place{
    private final ArrayList<Place> places = new ArrayList<>();
    public City(){
        super("Некоторый город");
    }
    public City(String name){
        super(name);
    }
    public void addPlace(Place place){
        places.add(place);
    }
    public ArrayList<Place> getPlaces(){
        return places;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (City) otherObject;
        return java.util.Objects.equals(places, other.getPlaces());
    }
    @Override
    public String toString(){
        return super.toString() + "[places=" + places.toString() + "]";
    }
}
