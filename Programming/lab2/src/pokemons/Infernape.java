package pokemons;

import attacks.CalmMind;

public class Infernape extends Monferno {
    {
        super.setStats(76,104,71,104,71,108);
        super.addMove(new CalmMind());
    }
    public Infernape(String name, int level){
        super(name, level);
    }
}