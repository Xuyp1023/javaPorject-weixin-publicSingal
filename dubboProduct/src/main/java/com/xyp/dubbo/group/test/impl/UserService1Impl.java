package com.xyp.dubbo.group.test.impl;

import org.springframework.stereotype.Service;

//import com.alibaba.dubbo.config.annotation.Service;
import com.xyp.dubbo.group.test.IUserService;

//@Service(interfaceClass = IUserService.class)
@Service
public class UserService1Impl implements IUserService {

    @Override
    public String eat(String anParam) {
        String result = "userService1Impl    ....anParam=" + anParam;
        System.out.println(result);
        return result;
    }

}
