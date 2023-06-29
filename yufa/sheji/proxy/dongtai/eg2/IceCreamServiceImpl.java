package sheji.proxy.dongtai.eg2;

public class IceCreamServiceImpl implements IceCreamService{
    @Override
    public void makeIceCream(String fruit) {
        int i = 1/0;
        System.out.println("制作："+fruit);
    }
}
