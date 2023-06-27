package com.test.spring.service;

import com.spring.Autowired;
import com.spring.Component;
import com.spring.Scope;

@Component("orderService")
@Scope("singleton")
public class OrderService {

    @Autowired
    private UserService userService;
}
