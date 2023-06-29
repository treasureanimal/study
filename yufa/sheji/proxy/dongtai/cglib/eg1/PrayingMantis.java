package sheji.proxy.dongtai.cglib.eg1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 *Enhancer 对象把代理对象设置为被代理类的子类来实现动态代理的。因为是采用继承方式，所以代理类不能加final修饰，否则会报错。
 *final类：类不能被继承，内部的方法和变量都变成final类型
 */
public class PrayingMantis implements MethodInterceptor {

    private Object target;// 代理对象

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("螳螂捕蝉 - 次要业务");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("黄雀在后 - 次要业务");
        return object;
    }

    public static void main(String[] args) {
        PrayingMantis prayingMantis = new PrayingMantis();
        Cicada instance = (Cicada)prayingMantis.getInstance(new Cicada());
        instance.mainService();
        // 结果：主要业务
        // 螳螂捕蝉 - 次要业务
    }
}