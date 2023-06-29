package sheji.proxy.dongtai.cglib.eg2;

import org.springframework.cglib.proxy.Enhancer;

public class CGlibProxy {
    public static void main(String[] args) {
        //创建Enhancer对象，类似于JDK动态代理的Proxy类，下一步就是设置几个参数
        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(RealSubject.class);
        //设置回调函数
        enhancer.setCallback(new MyMethodInterceptor());

        //这里的creat方法就是正式创建代理类
        RealSubject proxyDog = (RealSubject) enhancer.create();
        //调用代理类的eat方法
        proxyDog.request();
    }
}
