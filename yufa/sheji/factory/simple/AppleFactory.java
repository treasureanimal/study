package sheji.factory.simple;

public class AppleFactory extends FruitFactory {
    @Override
    public Fruit productFruit() {
        return new Apple();
    }
}
