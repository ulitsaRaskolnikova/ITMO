package attacks;

import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }
    @Override
    protected String describe() {
        return "использует Facade";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        switch (pokemon.getCondition()){
            case POISON, PARALYZE:
                this.power = 140;
                break;
            default:
                this.power = 70;
        }
    }
}
