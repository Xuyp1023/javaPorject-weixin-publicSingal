package com.xyp.custom.schema.handler.test;

public class UserServiceImpl implements IUserService {

    @Override
    public String eat(String food) {
        System.out.println("food");
        return food + "chichi";
    }

}
