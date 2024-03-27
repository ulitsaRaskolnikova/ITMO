package Places;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import Interfaces.IContainPersons;
import Persons.Person;
import Utils.GetterID;
public class Place implements IContainPersons {
    private String name;
    private ArrayList<Person> persons = new ArrayList<>();
    private final int id = GetterID.getID();
    public Place(){
        this.name = "Некоторое место";
    }
    public Place(String name){
        this.name = name;
    }
    public int getID() {
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public void setPersons(Person... persons){
        this.persons = new ArrayList<>(Arrays.asList(persons));
    }
    @Override
    public void rmAllPersons(){
        persons.clear();
    }
    @Override
    public ArrayList<Person> getPersons(){
        return persons;
    }
    @Override
    public void addPerson(Person person){
        persons.add(person);
    }
    @Override
    public void rmPerson(Person person){
        persons.remove(person);
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Place) otherObject;
        return Objects.equals(name, other.name);
    }
    @Override
    public int hashCode(){
        return id;
    }
    @Override
    public String toString(){
        return getClass().getName() + "[name=" + name + ",persons=" + persons + "]";
    }
}
