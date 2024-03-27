package Persons;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.Objects;

import Enums.Aroma;
import Enums.Emotion;
import Exceptions.SneezeException;
import Interfaces.Cleanable;
import Interfaces.Emotional;
import Things.Plan;
import Utils.GetterID;

public class Person implements Emotional {
    private String name;
    private Emotion emotion = Emotion.FINE;
    private final ArrayList<Plan> plans = new ArrayList<>();
    private final int id = GetterID.getID();
    private boolean isClean = false;
    private boolean areHandsClean = false;
    private boolean enoughSleep = false;
    private int satiety = 100;
    private int dirtyLevelOfTeeth = 100;
    private Aroma aroma = Aroma.NOTHING;
    public Person(String name){
        this.name = name;
    }
    @Override
    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
    @Override
    public Emotion getEmotion(){
        return emotion;
    }
    protected void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void addPlan(Plan plan){
        plans.add(plan);
    }
    public void rmPlan(Plan plan){
        plans.remove(plan);
    }
    protected ArrayList<Plan> getPlans(){
        return plans;
    }
    public void eat(){
        this.satiety = 100;
    }
    public int getSatiety(){
        return satiety;
    }
    public void setIsClean(boolean isClean){
        this.isClean = isClean;
    }
    public boolean getIsClean(){
        return isClean;
    }
    public void setAreHandsClean(boolean areHandsClean){
        this.areHandsClean = areHandsClean;
    }
    public boolean getAreHandsClean(){
        return areHandsClean;
    }
    public void sniff(Aroma aroma) throws SneezeException{
        if (Math.random() <= 0.3) throw new SneezeException();
        this.aroma = aroma;
    }
    public Aroma getAroma(){
        return aroma;
    }
    public void setEnoughSleep(boolean enoughSleep){
        this.enoughSleep = enoughSleep;
    }
    public boolean getEnoughSleep(){
        return enoughSleep;
    }
    public int getID(){
        return id;
    }
    public void cleanTeeth(){
        class Teeth implements Cleanable {
            @Override
            public void clean() {
                dirtyLevelOfTeeth = 0;
            }
        }
        var teeth = new Teeth();
        teeth.clean();
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Person) otherObject;
        return Objects.equals(name, other.name)
                && emotion == other.emotion
                && Objects.equals(plans, other.plans);
    }
    @Override
    public int hashCode(){
        return id;
    }
    @Override
    public String toString(){
        return getClass().getName() +
                "[name=" + name +
                ",emotion=" + emotion +
                ",plans=" + plans +
                "]";
    }
}
