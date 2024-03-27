package attacks;

import ru.ifmo.se.pokemon.*;

public class Overheat extends SpecialMove {
    public Overheat() {
        super(Type.FIRE, 130, 90);
    }
    @Override
    protected String describe() {
        return "использует Overheat";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK, (int) pokemon.getStat(Stat.SPECIAL_ATTACK) - 2);
        pokemon.addEffect(e);
    }
}
