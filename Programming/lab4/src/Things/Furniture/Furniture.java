package Things.Furniture;

import Things.PhysicalThing;

import java.util.Objects;

public abstract class Furniture extends PhysicalThing {
    public Furniture(){
        super("мебель");
    }
    public Furniture(String name){
        super(name);
    }
    abstract public void use(Object object);
}
