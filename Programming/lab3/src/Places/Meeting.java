package Places;

import Things.Interaction;

import java.util.ArrayList;

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
}
