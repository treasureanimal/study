package com.test.spring.service;

import com.spring.BeanPostProcessor;
import com.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


//在初始化前和初始化后的操作
@Component
public class XiaoXiongBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前bean = " + bean);
        if (beanName.equals("userService")) {
            ((UserServiceImpl) bean).setBeanName("小熊饼干");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后bean = " + bean);
        if (beanName.equals("userService")) {

            //使用jdk动态代理
            Object proxyInstance = Proxy.newProxyInstance(XiaoXiongBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("执行代理逻辑"); //找有没有切点
                    return method.invoke(bean,args);//执行代理方法
                }
            });
            return proxyInstance;
        }
        return bean;
    }
}
