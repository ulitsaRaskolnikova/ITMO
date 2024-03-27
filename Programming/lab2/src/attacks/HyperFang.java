package attacks;

import ru.ifmo.se.pokemon.*;

public class HyperFang extends PhysicalMove {
    public HyperFang() {
        super(Type.NORMAL, 80, 90);
    }
    @Override
    protected String describe() {
        return "использует Hyper Fang";
    }
    @Override
    protected void applyOppEffects(Pokemon pokemon){
        if (Math.random() <= 0.1) {
            Effect.flinch(pokemon);
        }
    }

}
