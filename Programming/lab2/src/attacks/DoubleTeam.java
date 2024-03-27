package attacks;

import ru.ifmo.se.pokemon.*;

public class DoubleTeam extends StatusMove {
    public DoubleTeam() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected String describe() {
        return "использует Double Team";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.EVASION, (int) pokemon.getStat(Stat.EVASION) + 1);
        pokemon.addEffect(e);
    }
}
