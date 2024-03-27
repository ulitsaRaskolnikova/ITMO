package Things;

import Enums.Color;

import java.util.Objects;

public class PhysicalThing {
    private Color color;
    private String description = "описания нет";
    private String name;
    public PhysicalThing(){
        color = Color.DEFAULT;
    }
    public PhysicalThing(String name){
        this.name = name;
        color = Color.DEFAULT;
    }
    public PhysicalThing(Color color){
        this.color = color;
    }
    public PhysicalThing(Color color, String description){
        this.color = color;
        this.description = description;
    }
    public void setName(String name){
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
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (PhysicalThing) otherObject;
        return Objects.equals(color, other.color) &&
                Objects.equals(description, other.description);
    }
    @Override
    public int hashCode(){
        return Objects.hash(color, description);
    }
    @Override
    public String toString(){
        return getClass().getName() + "[color=" + color + ",description=" + description + "]";
    }
}
