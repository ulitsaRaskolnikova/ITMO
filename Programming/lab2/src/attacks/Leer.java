package attacks;

import ru.ifmo.se.pokemon.*;

public class Leer extends StatusMove {
    public Leer() {
        super(Type.NORMAL, 0, 100);
    }
    @Override
    protected String describe() {
        return "использует Leer";
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.DEFENSE, (int) pokemon.getStat(Stat.DEFENSE) - 1);
        pokemon.addEffect(e);
    }
}
