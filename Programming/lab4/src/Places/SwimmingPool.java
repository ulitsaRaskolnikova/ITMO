package Places;

public class SwimmingPool extends Place{
    public SwimmingPool(){
        super("плавательный бассейн");
    }
    public SwimmingPool(String name){
        super(name);
    }
    private double volume = 110.0;
    public void setVolume(double volume){
        this.volume = volume;
    }
    public double getVolume(){
        return volume;
    }
    public class WaterInPool{
        private double temperature = 22.0;
        private boolean isClean = false;
        private double volume = 100.0;
        public void clean(){
            isClean = true;
        }
        public boolean isClean(){
            return isClean;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }
        public double getTemperature() {
            return temperature;
        }
        public void setVolume(double temperature) {
            this.temperature = temperature;
        }
        public double getVolume(){
            return temperature;
        }
    }
}
