package sheji.eg1;

public class test {

    public static void main(String[] args) {
        ShopBuilder builder = new FruitShopBuilder();
        Dealer dealer = new Dealer();
        dealer.setBuilder(builder);

        Shop shop = dealer.build("XX水果店", "福州市XX区XX街XX号", "水果经营");
        System.out.println(shop);
    }
}
