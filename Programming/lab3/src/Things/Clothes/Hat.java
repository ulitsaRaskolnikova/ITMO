package Things.Clothes;

import Enumerations.Color;
import Enumerations.Size;
import Enumerations.TypeOfClothes.TypeOfHat;
import Enumerations.TypeOfClothes.TypeOfPants;

import java.util.Objects;

public class Hat extends Clothes {
    TypeOfHat type;
    {
        super.setName("Шляпа");
    }
    public Hat(){
        super();
        this.type = TypeOfHat.TOP_HAT;
        super.setType(TypeOfHat.TOP_HAT);
    }
    public Hat(Color color, String shapeDiscription, TypeOfHat type){
        super(color, shapeDiscription);
        this.type = type;
        super.setType(type);
    }
    public Hat(TypeOfHat type){
        super();
        this.type = type;
        super.setType(type);
    }
    public Hat(Size size, TypeOfHat type){
        super(size);
        this.type = type;
        super.setType(type);
    }
    public String getRusType(){
        return type.getRusType();
    }
    public void setType(TypeOfHat type){
        super.setType(type);
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Hat) otherObject;
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
