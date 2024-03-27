package Persons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import Interfaces.Emotional;
import Interfaces.FindOut;
import Things.Plan;
import Enums.Emotion;
import Interfaces.Blabable;

public class Crabs extends Person implements FindOut {
    private HashMap<Person, ArrayList<Plan>> opponentPlans = new HashMap<>();
    public Crabs(){
        super("Крабс");
    }
    public Crabs(String name){
        super(name);
    }

    public <from extends Blabable> void findOutPlans(Person from){
        var oppPlans = opponentPlans.get(from);
        if (oppPlans == null){
            opponentPlans.put(from, from.getPlans());
        }
        else{
            oppPlans.addAll(((Blabable) from).getPlans());
            opponentPlans.put(from, oppPlans);
        }
    }
    public HashMap<Person,ArrayList<Plan>> getOppPlans(){
        return opponentPlans;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Crabs) otherObject;
        return Objects.equals(opponentPlans, other.opponentPlans);
    }
    @Override
    public String toString() {
        return super.toString() +
                "[opponentPlans=" + opponentPlans + "]";
    }
}
