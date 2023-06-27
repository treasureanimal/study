package com.zhouyu.springboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
public class AopAutoConfiguration implements AutoConfiguration {

    //这样springboot使用aop时就会自动开启aop
    @EnableAspectJAutoProxy
    @Configuration
    @ConditionalOnClass("org.aspectj.weaver.Advice")
    class AspectjConfiguration{

    }
}
