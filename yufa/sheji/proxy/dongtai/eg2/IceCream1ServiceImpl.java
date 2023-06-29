package sheji.proxy.dongtai.eg2;

public class IceCream1ServiceImpl implements IceCreamService{
    @Override
    public void makeIceCream(String fruit) {
        System.out.println("制作："+fruit);
    }
}
