package sheji.proxy.dongtai.eg3;

import java.lang.reflect.Proxy;

public class ProxyFactory {
    private Object target;// 维护一个目标对象

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("计算开始时间");
                    // 执行目标对象方法
                    method.invoke(target, args);
                    System.out.println("计算结束时间");
                    return null;
                });
    }
        public static void main(String[] args) {
            RealSubject realSubject = new RealSubject();
            System.out.println(realSubject.getClass());
            Subject subject = (Subject) new ProxyFactory(realSubject).getProxyInstance();
            System.out.println(subject.getClass());
            subject.request();
        }
}
