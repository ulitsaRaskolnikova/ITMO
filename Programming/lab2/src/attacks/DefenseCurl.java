package attacks;

import ru.ifmo.se.pokemon.*;

public class DefenseCurl extends StatusMove {
    public DefenseCurl() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected String describe() {
        return "использует Defense Curl";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.DEFENSE, (int) pokemon.getStat(Stat.DEFENSE) + 1);
        pokemon.addEffect(e);
    }
}
