package Things.HygieneThings;

import Enums.Aroma;
import Things.AromaThing;
import Things.PhysicalThing;

public class ToothPowderBox extends PhysicalThing {
    public ToothPowderBox(){
        super("коробка из-под зубного порошка");
    }
    private boolean isOpened = false;
    public final ToothPowder toothPowder = new ToothPowder();
    public ToothPowderBox(boolean isOpened){
        super("коробка из-под зубного порошка");
        this.isOpened = isOpened;
    }
    public void open(){
        isOpened = true;
    }
    public void close(){
        isOpened = false;
    }
    public boolean isOpened(){
        return isOpened;
    }
    public void putToothBrushToBox(){
        if (toothPowder.powderWeight >= 1){
            toothPowder.powderWeight--;
        }
    }
    public void addPowder(){
        toothPowder.powderWeight = 100;
    }
    public class ToothPowder extends AromaThing {
        private double powderWeight = 0;
        public ToothPowder(){
            super("зубной порошок");
        }
        public ToothPowder(Aroma aroma){
            super("зубной порошок", aroma);
        }
        public Aroma smell() {
            if (isOpened){
                return super.getAroma();
            }
            else{
                return Aroma.NOTHING;
            }
        }
        public void setPowderWeight(double powderWeight){
            this.powderWeight = powderWeight;
        }
        public double getPowderWeight(){
            return powderWeight;
        }
        public void fly(){
            if (isOpened){
                powderWeight = 0;
            }
        }
    }
}
