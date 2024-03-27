package Things.Clothes;

import Enumerations.Color;
import Enumerations.Size;
import Enumerations.TypeOfClothes.TypeOfHat;
import Enumerations.TypeOfClothes.TypeOfJacket;

import java.util.Objects;

public class Jacket extends Clothes {
    TypeOfJacket type;
    {
        super.setName("Пиджак");
    }
    public Jacket(){
        super();
        type = TypeOfJacket.CLASSIC;
        super.setType(type);
    }
    public Jacket(TypeOfJacket type){
        this.type = type;
    }
    public Jacket(Size size, TypeOfJacket type){
        super(size);
        this.type = type;
        super.setType(type);
    }
    public Jacket(Color color, String shapeDiscription, TypeOfJacket type){
        super(color, shapeDiscription);
        this.type = type;
        super.setType(type);
    }
    public String getRusType(){
        return type.getRusType();
    }
    public void setType(TypeOfJacket type){
        super.setType(type);
    }
    public TypeOfJacket getType(){
        return type;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Jacket) otherObject;
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
