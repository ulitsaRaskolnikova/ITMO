package Places;

import java.util.ArrayList;
import java.util.Objects;
import Persons.Person;
import Tools.GetterID;
public class Place {
    private String name;
    private final ArrayList<Person> persons = new ArrayList<>();
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
    public ArrayList<Person> getPersons(){
        return persons;
    }
    public void addPerson(Person person){
        persons.add(person);
    }
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
