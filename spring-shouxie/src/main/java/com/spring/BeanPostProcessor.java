package com.spring;

public interface BeanPostProcessor {

    //在初始化前的一些操作
    Object postProcessBeforeInitialization(Object bean, String beanName);

    //在初始化后的一些操作
    Object postProcessAfterInitialization(Object bean, String beanName);
}
