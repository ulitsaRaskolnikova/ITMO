package attacks;

import ru.ifmo.se.pokemon.*;

public class Crunch extends PhysicalMove {
    public Crunch() {
        super(Type.DARK, 80, 100);
    }
    @Override
    protected String describe() {
        return "использует Crunch";
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        Effect e = new Effect().chance(0.2).stat(Stat.DEFENSE, (int) pokemon.getStat(Stat.DEFENSE) - 1);
        pokemon.addEffect(e);
    }
}
