package Persons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import Interfaces.Emotional;
import Interfaces.FindOut;
import Things.Clothes.Hat;
import Things.Plan;
import Enumerations.Emotion;
import Interfaces.Blabable;

public class Crabs extends Person implements FindOut, Emotional {
    private Emotion emotion;
    private HashMap<Person, ArrayList<Plan>> opponentPlans = new HashMap<>();
    public Crabs(){
        super("Крабс");
    }
    public Crabs(String name){
        super(name);
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    public Emotion getEmotion(){
        return emotion;
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
        return emotion == other.emotion &&
                Objects.equals(opponentPlans, other.opponentPlans);
    }
    @Override
    public String toString() {
        return super.toString() +
                "[emotion=" + emotion +
                ",opponentPlans=" + opponentPlans + "]";
    }
}
