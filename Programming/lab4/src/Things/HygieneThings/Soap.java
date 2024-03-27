package Things.HygieneThings;

import Enums.Aroma;
import Persons.Person;
import Things.AromaThing;

public class Soap extends AromaThing {
    public Soap(){
        super("мыло");
    }
    public Soap(Aroma aroma){
        super("мыло", aroma);
    }
    public void washHands(Person person){
        person.setAreHandsClean(true);
    }

}
