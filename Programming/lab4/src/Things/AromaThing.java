package Things;

import Enums.Aroma;
import Things.MaterialThings.MaterialThing;

import java.util.Objects;

public class AromaThing extends PhysicalThing {
    Aroma aroma;
    public AromaThing(){
        super();
        aroma = Aroma.NOTHING;
    }
    public AromaThing(String name){
        super(name);
        aroma = Aroma.NOTHING;
    }
    public AromaThing(String name, Aroma aroma){
        super(name);
        this.aroma = aroma;
    }
    public void setAroma(Aroma aroma){
        this.aroma = aroma;
    }
    public Aroma getAroma(){
        return aroma;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (AromaThing) otherObject;
        return aroma == other.aroma;
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), aroma);
    }
    @Override
    public String toString(){
        return super.toString() + "[aroma=" + aroma + "]";
    }

}
