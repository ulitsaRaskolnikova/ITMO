package Persons;

import Enums.Emotion;
import Enums.Intonation;
import Enums.WaveStyle;
import Interfaces.Blabable;
import Interfaces.Emotional;
import Interfaces.Interactable;
import Things.Plan;

import java.util.ArrayList;

public class Scooperfield extends Person implements Interactable, Blabable {
    private WaveStyle waveStyle;
    private Intonation intonation;
    public Scooperfield(){
        super("Скуперфильд");
    }
    public Scooperfield(String name){
        super(name);
    }
    public void setWaveStyle(WaveStyle waveStyle){
        this.waveStyle = waveStyle;
    }
    public WaveStyle getWaveStyle(){
        return waveStyle;
    }
    public void setIntonation(Intonation intonation){
        this.intonation = intonation;
    }
    public Intonation getIntonation(){
        return intonation;
    }
    public ArrayList<Plan> getPlans(){
        return super.getPlans();
    }
    @Override
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        var other = (Scooperfield) otherObject;
        return waveStyle == other.waveStyle &&
                intonation == other.intonation;
    }
    @Override
    public String toString(){
        return super.toString() +
                "[waveStyle=" + waveStyle +
                ",intonation=" + intonation + "]";
    }
}
