package Things;

import Persons.Person;

import java.util.Objects;

public class Telegram {
    private String text = "";
    private double price = 0.0;
    private Person byPerson;
    public Telegram(Person byPerson){
        this.byPerson = byPerson;
    }
    public Telegram(String text){
        this.text = text;
    }
    public Telegram(Person byPerson, String text){
        this.byPerson = byPerson;
        this.text = text;
    }
    public Telegram(String Text, double price){
        this.text = text;
        this.price = price;
    }
    public void setByPerson(Person byPerson){
        this.byPerson = byPerson;
    }
    public Person getByPerson(){
        return byPerson;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Telegram) otherObject;
        final double EPS = 0.0001;
        return Objects.equals(text, other.text) &&
                Math.abs(price - other.price) < EPS;
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), text, price);
    }
    @Override
    public String toString(){
        return super.toString() +
                "[text=" + text +
                ",price=" + price + "]";
    }
}
