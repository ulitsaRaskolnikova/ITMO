package Places;

import Enums.Emotion;
import Persons.Person;

public class Bredlam extends Meeting{
    public static class Capitalist extends Person {
        public Capitalist(){
            super("капиталист");
        }
    }
    public void makeAngry(){
        for(var person : super.getPersons()){
            if (person.getClass() == Capitalist.class){
                person.setEmotion(Emotion.ANGRY);
            }
        }
    }
}
