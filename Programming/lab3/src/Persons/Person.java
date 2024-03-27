package Persons;

import java.util.ArrayList;
import java.util.Objects;

import Things.Plan;
import Tools.GetterID;

public abstract class Person {
    private String name;
    private final ArrayList<Plan> plans = new ArrayList<>();
    private final int id = GetterID.getID();
    public Person(String name){
        this.name = name;
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
    public int getID(){
        return id;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (Person) otherObject;
        return Objects.equals(name, other.name) && Objects.equals(plans, other.plans);
    }
    @Override
    public int hashCode(){
        return id;
    }
    @Override
    public String toString(){
        return getClass().getName() +
                "[name=" + name +
                ",plans=" + plans +
                "]";
    }
}
