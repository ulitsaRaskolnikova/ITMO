package attacks;

import ru.ifmo.se.pokemon.*;

public class AuroraBeam extends SpecialMove {
    public AuroraBeam() {
        super(Type.ICE, 65, 100);
    }
    @Override
    protected String describe() {
        return "использует Aurora Beam";
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        Effect e = new Effect().chance(0.1).stat(Stat.ATTACK, (int) pokemon.getStat(Stat.ATTACK) - 1);
        pokemon.addEffect(e);
    }
}
