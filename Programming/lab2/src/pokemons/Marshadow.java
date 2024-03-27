package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.*;
public class Marshadow extends Pokemon {
    {
        super.setStats(90,125,80,90,90,125);
        super.setType(Type.FIGHTING, Type.GHOST);
        super.setMove(new AuroraBeam(), new DefenseCurl(), new Swagger(), new DoubleTeam());
    }
    public Marshadow(String name, int level){
        super(name, level);
    }

}
