package Things.Furniture;

import Interfaces.IContainPersons;
import Persons.Person;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class FurnitureContainsPeople extends Furniture implements IContainPersons {
    private ArrayList<Person> persons = new ArrayList<>();
    public FurnitureContainsPeople(){
        super();
    }
    public FurnitureContainsPeople(String name){
        super(name);
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
    public void setPersons(Person... persons){
        this.persons = new ArrayList<>(Arrays.asList(persons));
    }
    @Override
    public void rmAllPersons(){
        persons.clear();
    }
}
