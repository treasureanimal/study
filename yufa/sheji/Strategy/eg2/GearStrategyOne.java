package sheji.Strategy.eg2;

public class GearStrategyOne implements  GearStrategy{
    @Override
    public void algotithm(String param) {
        System.out.println("当前挡位"+param);
    }
}
