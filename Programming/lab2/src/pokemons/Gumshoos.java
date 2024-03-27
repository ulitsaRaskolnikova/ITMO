package pokemons;

import ru.ifmo.se.pokemon.*;
import attacks.*;
public class Gumshoos extends Yungoos {
    {
        super.setStats(88,110,60,55,60,45);
        super.addMove(new Bulldoze());
    }
    public Gumshoos(String name, int level){
        super(name, level);
    }

}
