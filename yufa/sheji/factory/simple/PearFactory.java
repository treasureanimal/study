package sheji.factory.simple;

public class PearFactory extends FruitFactory {
    @Override
    public Fruit productFruit() {
        return new Pear();
    }
}
