package Things;

import Enumerations.Color;
import Places.Place;

import java.util.Objects;

public abstract class PhysicalThing {
    private Color color;
    private String shapeDescription = "описания нет";
    private String name;
    public PhysicalThing(){
        color = Color.DEFAULT;
    }
    public PhysicalThing(Color color){
        this.color = color;
    }
    public PhysicalThing(Color color, String shapeDescription){
        this.color = color;
        this.shapeDescription = shapeDescription;
    }
    protected void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
    public void setShape(String shapeDescription){
        this.shapeDescription = shapeDescription;
    }
    public String getShape(){
        return shapeDescription;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (PhysicalThing) otherObject;
        return Objects.equals(color, other.color) &&
                Objects.equals(shapeDescription, other.shapeDescription);
    }
    @Override
    public int hashCode(){
        return Objects.hash(color, shapeDescription);
    }
    @Override
    public String toString(){
        return getClass().getName() + "[color=" + color + ",shapeDescription=" + shapeDescription + "]";
    }
}
