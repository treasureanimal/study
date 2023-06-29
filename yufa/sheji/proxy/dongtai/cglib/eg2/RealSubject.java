package sheji.proxy.dongtai.cglib.eg2;

import sheji.proxy.dongtai.eg3.Subject;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println(" = 卖房");
    }
}
