package Things.Clothes;

import Enums.Color;
import Enums.Size;
import Enums.TypeOfClothes.TypeOfSocks;

import java.util.Objects;

public class Socks extends Clothes {
    TypeOfSocks type;
    {
        super.setName("Носки");
    }
    public Socks(){
        super();
        type = TypeOfSocks.REGULAR;
        super.setType(type);
    }
    public Socks(TypeOfSocks type){
        this.type = type;
    }
    public Socks(Size size, TypeOfSocks type){
        super(size);
        this.type = type;
        super.setType(type);
    }
    public Socks(Color color, String shapeDescription, TypeOfSocks type){
        super(color, shapeDescription);
        this.type = type;
        super.setType(type);
    }
    public Socks(TypeOfSocks type, String shapeDescription){
        this.type = type;
        super.setDescription(shapeDescription);
    }
    public String getRusType(){
        return type.getRusType();
    }
    public void setType(TypeOfSocks type){
        super.setType(type);
    }
    public TypeOfSocks getType(){
        return type;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Socks) otherObject;
        return Objects.equals(type, other.type);
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), type);
    }
    @Override
    public String toString(){
        return super.toString() + "[type=" + type + "]";
    }
}
