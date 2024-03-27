package Transfers;

import Persons.Person;
import Things.Clothes.Clothes;
import Things.PhysicalThing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Arrays;

public class Inventory {
    private final HashMap<Person, ArrayList<PhysicalThing>> inventory = new HashMap<>();
    public void setThingsToPerson(Person person, PhysicalThing... thingsArr){
        var things = new ArrayList<PhysicalThing>(Arrays.asList(thingsArr));
        inventory.put(person, things);
    }
    public void addThingToPerson(Person person, PhysicalThing thing){
        ArrayList<PhysicalThing> things = inventory.get(person);
        if (things == null){
            var newThing = new ArrayList<PhysicalThing>();
            newThing.add(thing);
            inventory.put(person, newThing);
        }
        else{
            things.add(thing);
            inventory.put(person, things);
        }
    }
    public ArrayList<PhysicalThing> getInventoryOfPerson(Person person){
        return inventory.get(person);
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Inventory) otherObject;
        return Objects.equals(inventory, other.inventory);
    }
    @Override
    public int hashCode(){
        return inventory.hashCode();
    }
    @Override
    public String toString(){
        return getClass().getName() + "[inventory=" + inventory + "]";
    }
}
