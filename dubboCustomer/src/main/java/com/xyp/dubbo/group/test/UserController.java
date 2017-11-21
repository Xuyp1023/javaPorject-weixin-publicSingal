package com.xyp.dubbo.group.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/controller/user")
public class UserController {

    // @Reference(interfaceClass = IUserService.class)
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/test", method = { RequestMethod.POST, RequestMethod.GET })
    public @ResponseBody String eat(String name) {
        String string = userService.eat(name);
        return string;
    }

}
