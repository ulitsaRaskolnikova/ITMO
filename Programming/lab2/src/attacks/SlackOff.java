package attacks;

import ru.ifmo.se.pokemon.*;

public class SlackOff extends StatusMove {
    public SlackOff() {
        super(Type.NORMAL, 0, 0);
    }
    @Override
    protected String describe() {
        return "использует Slack Off";
    }
    @Override
    protected void applySelfEffects(Pokemon pokemon){
        Effect e = new Effect().stat(Stat.HP, (int) (pokemon.getHP() + 0.5 * pokemon.getStat(Stat.HP)));
        pokemon.addEffect(e);
    }
}
