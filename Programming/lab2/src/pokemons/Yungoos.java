package pokemons;

import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Yungoos extends Pokemon {
    {
        super.setStats(48,70,30,30,30,45);
        super.setType(Type.NORMAL);
        super.setMove(new Crunch(), new HyperFang(), new Leer());
    }
    public Yungoos(String name, int level){
        super(name, level);
    }

}
