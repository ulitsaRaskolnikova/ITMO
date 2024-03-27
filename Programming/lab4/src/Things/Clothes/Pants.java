package Things.Clothes;

import Enums.Color;
import Enums.Size;
import Enums.TypeOfClothes.TypeOfPants;

import java.util.Objects;

public class Pants extends Clothes {
    TypeOfPants type;
    {
        super.setName("Штаны");
    }
    public Pants(){
        super();
        type = TypeOfPants.TROUSERS;
        super.setType(TypeOfPants.TROUSERS);
    }
    public Pants(Color color, String shapeDescription, TypeOfPants type){
        super(color, shapeDescription);
        this.type = TypeOfPants.TROUSERS;
        super.setType(type);
    }
    public Pants(Color color, TypeOfPants type){
        super(color);
        this.type = type;
        super.setType(type);
    }
    public Pants(TypeOfPants type){
        super();
        this.type = type;
        super.setType(type);
    }
    public Pants(Size size, TypeOfPants type){
        super(size);
        this.type = type;
        super.setType(type);
    }
    public String getRusType(){
        return type.getRusType();
    }
    public void setType(TypeOfPants type){
        this.type = type;
    }
    public TypeOfPants getType(){
        return type;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Pants) otherObject;
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
