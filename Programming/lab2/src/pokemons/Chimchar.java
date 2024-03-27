package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Chimchar extends Pokemon {
    {
        super.setStats(44,58,44,58,44,61);
        super.setType(Type.FIRE);
        super.setMove(new Facade(), new Overheat());
    }
    public Chimchar(String name, int level){
        super(name, level);
    }
}