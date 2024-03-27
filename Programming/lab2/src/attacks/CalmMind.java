package attacks;

import ru.ifmo.se.pokemon.*;

public class CalmMind extends StatusMove {
    public CalmMind() {
        super(Type.PSYCHIC, 0, 0);
    }
    @Override
    protected String describe() {
        return "использует Calm Mind";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.SPECIAL_ATTACK, (int) pokemon.getStat(Stat.SPECIAL_ATTACK) + 1)
                .stat(Stat.SPECIAL_DEFENSE, (int) pokemon.getStat(Stat.SPECIAL_DEFENSE) + 1);
        pokemon.addEffect(e);
    }
}
