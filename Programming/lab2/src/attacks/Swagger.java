package attacks;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }
    @Override
    protected String describe() {
        return "использует Swagger";
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.ATTACK, (int) pokemon.getStat(Stat.ATTACK) + 2);
        pokemon.addEffect(e);
        Effect.confuse(pokemon);
    }
}
