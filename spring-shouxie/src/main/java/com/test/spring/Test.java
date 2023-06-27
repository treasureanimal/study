package com.test.spring;

import com.spring.XiaoXiongApplicationContext;
import com.test.spring.controller.UserController;
import com.test.spring.service.UserService;
import com.test.spring.service.UserServiceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws Exception {
        XiaoXiongApplicationContext applicationContext = new XiaoXiongApplicationContext(AppConfig.class);
        System.out.println(applicationContext.getBean("userService"));
        System.out.println(applicationContext.getBean("userService"));
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();  //1.先执行代理逻辑， 2，执行业务对象

        UserController userController = new UserController();
        Class<? extends UserController> aClass = userController.getClass();
        Field userService1 = aClass.getDeclaredField("userService");
        userService1.setAccessible(true);
        //只有通过方法才能获得具体的属性值
        String name = userService1.getName();
        //拼接方法的名称
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
        String setMethodName = "set" + name;
        //通过方法注入属性的对象
        Method method = aClass.getMethod(setMethodName, UserService.class);
        method.invoke(userController,userService);
        System.out.println(userController.getUserService());

    }
}
