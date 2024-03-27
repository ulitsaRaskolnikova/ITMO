package Things.Furniture;

import Persons.Person;

public class Bath extends FurnitureContainsPeople{
    public Bath(){
        super("ванна");
    }
    @Override
    public void use(Object object) {
        var person = (Person) object;
        person.setIsClean(true);
    }
}
