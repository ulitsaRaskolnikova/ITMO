package Places;

import Enums.Intonation;
import Enums.WaveStyle;
import Interfaces.Interactable;
import Persons.Person;
import Places.Meeting;

import java.util.ArrayList;
import java.util.Objects;

public class Meeting extends Place {
    private final ArrayList<Interaction> interactions = new ArrayList<>();
    public Meeting(){
        super("Встреча");
    }
    public void addInteraction(Interaction interaction){
        interactions.add(interaction);
    }
    public ArrayList<Interaction> getInteractions(){
        return interactions;
    }
    public class Interaction {
        private Person fromPerson;
        private Person toPerson;
        private WaveStyle waveStyle = WaveStyle.NOTHING;
        private Intonation intonation = Intonation.NOTHING;
        private String info = "";
        public Interaction(Person fromPerson, Person toPerson, String info){
            this.fromPerson = fromPerson;
            this.toPerson = toPerson;
            this.info = info;
            if (fromPerson instanceof Interactable person){
                waveStyle = person.getWaveStyle();
                intonation = person.getIntonation();
            }
        }
        public Interaction(Person fromPerson, Person toPerson){
            this.fromPerson = fromPerson;
            this.toPerson = toPerson;
            if (fromPerson instanceof Interactable person){
                waveStyle = person.getWaveStyle();
                intonation = person.getIntonation();
            }
        }
        public void setFromPerson(Person fromPerson){
            this.fromPerson = fromPerson;
        }
        public Person getFromPerson(){
            return fromPerson;
        }
        public void setToPerson(Person toPerson){
            this.toPerson = toPerson;
        }
        public Person getToPerson(){
            return toPerson;
        }
        public WaveStyle getWaveStyle(){
            return waveStyle;
        }
        public Intonation getIntonation(){
            return intonation;
        }
        public void setInfo(String phrase){
            this.info = phrase;
        }
        public String getInfo(){
            return info;
        }
        @Override
        public boolean equals(Object otherObject){
            if (this == otherObject) return true;
            if (otherObject == null) return false;
            if (getClass() != otherObject.getClass()) return false;
            var other = (Meeting.Interaction) otherObject;
            return Objects.equals(fromPerson, other.fromPerson) &&
                    Objects.equals(toPerson, other.toPerson) &&
                    waveStyle == other.waveStyle &&
                    intonation == other.intonation &&
                    Objects.equals(info, other.info);
        }
        @Override
        public int hashCode(){
            return Objects.hash(fromPerson, toPerson, waveStyle, intonation, info);
        }
        @Override
        public String toString(){
            return getClass().getName() +
                    "[fromPerson=" + fromPerson +
                    ",toPerson=" + toPerson +
                    ",waveStyle=" + waveStyle +
                    ",intonation=" + intonation +
                    ",info=" + info +
                    "]";
        }
    }
}
