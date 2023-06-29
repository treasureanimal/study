package sheji.proxy.dongtai.eg1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StockHandler implements InvocationHandler {

    /**
     * 被代理类
     */
    private Object target;

    /**
     * 库存
     */
    private static Integer stock = 1;

    public StockHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(stock>0){
            method.invoke(target,null);
            stock--;
        }else {
            throw new RuntimeException("库存不足");
        }

        return null;
    }
}
