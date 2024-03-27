package Places;

import Interfaces.IMakeDirty;
import Persons.Person;

import java.util.ArrayList;

public class NightTheatre extends Place {
    private ArrayList<Person> actors = new ArrayList<>();
    public void addActor(Person person){
        actors.add(person);
    }
    public void throwAtActors(IMakeDirty dirty){
        for(var actor : actors){
            dirty.makeDirty(actor);
        }
    }
}
