package attacks;

import ru.ifmo.se.pokemon.*;

public class Bulldoze extends PhysicalMove {
    public Bulldoze() {
        super(Type.GROUND, 60, 100);
    }
    @Override
    protected String describe() {
        return "использует Bulldoze";
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.SPEED, (int) pokemon.getStat(Stat.SPEED) - 1);
        pokemon.addEffect(e);
    }
}
