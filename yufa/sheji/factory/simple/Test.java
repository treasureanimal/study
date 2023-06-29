package sheji.factory.simple;

public class Test {
    public static void main(String[] args) {
        FruitFactory fruitFactory = new PearFactory();
        Fruit apple = fruitFactory.productFruit();
        apple.eat();
    }
}
