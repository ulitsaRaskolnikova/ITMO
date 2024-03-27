import pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Marshadow straight = new Marshadow("Стрит", 1);
        Yungoos flush = new Yungoos("Флеш", 1);
        Gumshoos three = new Gumshoos("Сет", 1);
        Chimchar fullHouse = new Chimchar("Фул-хаус", 1);
        Monferno four = new Monferno("Каре", 1);
        Infernape royalFlush = new Infernape("Флеш-рояль", 1);

        b.addAlly(straight);
        b.addAlly(three);
        b.addAlly(four);
        b.addFoe(flush);
        b.addFoe(fullHouse);
        b.addFoe(royalFlush);

        b.go();
    }
}