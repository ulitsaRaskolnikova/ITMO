package Transfers;

import Persons.Person;
import Things.PhysicalThing;
import Things.Telegram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TelegramTransfer {
    private final HashMap<Person, ArrayList<Telegram>> telegrams = new HashMap<>();
    public void sendTelegramToPerson(Person person, Telegram telegram){
        ArrayList<Telegram> personTelegrams = telegrams.get(person);
        if (personTelegrams == null){
            var newTelegram = new ArrayList<Telegram>();
            newTelegram.add(telegram);
            telegrams.put(person, newTelegram);
        }
        else{
            personTelegrams.add(telegram);
            telegrams.put(person, personTelegrams);
        }
    }
    public ArrayList<Telegram> getPersonTelegrams(Person person){
        return telegrams.get(person);
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        var other = (TelegramTransfer) otherObject;
        return Objects.equals(telegrams, other.telegrams);
    }
    @Override
    public int hashCode(){
        return telegrams.hashCode();
    }
    @Override
    public String toString(){
        return getClass().getName() + "[telegrams=" + telegrams + "]";
    }
}
