package sheji.Strategy.eg3;

public class Test {

    public static void main(String[] args) {
        ShareFactory shareFactory = new ShareFactory();
        shareFactory.setShareStrategy(new OrderItemShare());
        shareFactory.doshareAlgorithm("order");

    }
}
