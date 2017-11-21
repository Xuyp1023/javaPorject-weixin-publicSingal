package com.xyp.dubbo.group.test.impl;

import com.xyp.dubbo.group.test.IUserService;

public class UserService2Impl implements IUserService {

    @Override
    public String eat(String anParam) {
        String result = "UserService2Impl    ....anParam=" + anParam;
        System.out.println(result);
        return result;
    }

}
