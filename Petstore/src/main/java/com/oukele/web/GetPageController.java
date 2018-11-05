package com.oukele.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/page")
public class GetPageController {

    //登录页面
    @RequestMapping(path = "/login")
    public String getLogin(Model model){
        return "login";
    }

    //注册页面
    @RequestMapping(path = "/reg")
    public String getReg(Model model){
        return "user";
    }

    //宠物列表
    @RequestMapping(path = "/pet")
    public String getPet(Model model){
        return "pet";
    }

}
