package sheji.proxy.dongtai.eg3;

public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println(" = 卖房");
    }
}
