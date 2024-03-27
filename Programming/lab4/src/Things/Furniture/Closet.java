package Things.Furniture;

import Things.PhysicalThing;

import java.util.ArrayList;

public class Closet extends Furniture{
    ArrayList<PhysicalThing> things = new ArrayList<>();
    public Closet(){
        super("шкаф");
    }
    @Override
    public void use(Object object) {
        var thing = (PhysicalThing) object;
        things.add(thing);
    }
}
