package cn.study.controller;

import cn.study.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="user")
public class UserController {

    private HrmService hrmService;

    @Autowired
    public void setUserService(HrmService hrmService){
        this.hrmService = hrmService;
    }
    @RequestMapping(value="/login")
    public void login() throws Exception{
    }

    @RequestMapping(value="/register")
    public String register() throws Exception{
        this.hrmService.save();
        return "results";
    }
}
