package Things.Furniture;

import Persons.Person;

public class Bed extends FurnitureContainsPeople{
    public Bed(){
        super("постель");
    }
    @Override
    public void use(Object object) {
        var person = (Person) object;
        person.setEnoughSleep(true);
    }
}
