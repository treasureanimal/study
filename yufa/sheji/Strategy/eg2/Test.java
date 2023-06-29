package sheji.Strategy.eg2;

public class Test {
    public static void main(String[] args) {
        Gear gear = new Gear();
        gear.setGearStrategy(new GearStrategyOne());
        gear.doGear("two");
    }
}