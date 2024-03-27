package pokemons;

import attacks.SlackOff;
import ru.ifmo.se.pokemon.Type;

public class Monferno extends Chimchar {
    {
        super.setStats(64,78,52,78,52,81);
        super.addType(Type.FIGHTING);
        super.addMove(new SlackOff());
    }
    public Monferno(String name, int level){
        super(name, level);
    }
}