package cn.springmvc.controller;

import cn.springmvc.annotation.Test;
import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 王涛涛 on 2016/2/15.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("index")
    public String index(){
        User user = new User();
        user.setNickname("daohahha");
        user.setState(233);
        userService.insertUser(user);
        return "index";
    }

    @Autowired
    private Test myTest;

    @RequestMapping("/async")
    public String async(){
        myTest.testAsyncMethod();
        System.out.println("我已经执行了！");
        return "index";
    }
}
