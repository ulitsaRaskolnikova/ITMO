package Things.Clothes;

import Enumerations.Color;
import Enumerations.Size;
import Things.PhysicalThing;

import java.util.Objects;

public abstract class Clothes extends PhysicalThing {
    private Size size = Size.MEDIUM;
    private Enum<?> type;
    public void setType(Enum<?> type){
        this.type = type;
    }
    public Enum<?> getType(){
        return type;
    }
    abstract public String getRusType();
    public Clothes(){
        size = Size.MEDIUM;
    }
    public Clothes(Color color){
        super(color);
    }
    public Clothes(Color color, String shapeDiscription){
        super(color, shapeDiscription);
    }
    public Clothes(Size size){
        this.size = size;
    }
    public void setSize(Size size){
        this.size = size;
    }
    public Size getSize(){
        return size;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Clothes) otherObject;
        return Objects.equals(size, other.size);
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), size);
    }
    @Override
    public String toString(){
        return super.toString() + "[size=" + size + "]";
    }
}
