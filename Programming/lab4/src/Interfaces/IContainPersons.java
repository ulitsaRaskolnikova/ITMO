package Interfaces;

import Persons.Person;

import java.util.ArrayList;

public interface IContainPersons {
    void addPerson(Person person);
    void setPersons(Person... persons);
    void rmPerson(Person person);
    void rmAllPersons();
    ArrayList<Person> getPersons();
}
