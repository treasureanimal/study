package com.test.spring.service;

import com.spring.*;

@Component("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService,BeanNameAware {

    @Autowired
    private OrderService orderService;

    private String  beanName;



    public void test(){
        System.out.println(orderService);
        System.out.println(beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
