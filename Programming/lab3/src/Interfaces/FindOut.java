package Interfaces;

import Persons.Person;
import Things.Plan;

import java.util.ArrayList;
import java.util.HashMap;

public interface FindOut {
    <from extends Blabable> void findOutPlans(Person from);
    HashMap<Person, ArrayList<Plan>> getOppPlans();
}
