package sheji.Strategy.eg2;

public class Gear {

    private GearStrategy gearStrategy;

    public void setGearStrategy(GearStrategy gearStrategy) {
        this.gearStrategy = gearStrategy;
    }

    public void doGear(String type){
        this.gearStrategy.algotithm(type);
    }
}
