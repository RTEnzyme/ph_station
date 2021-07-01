package com.lemon.admin.RT_Enzyme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody
public class LoginController {

    @GetMapping("/login")
    public ModelAndView loginPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.html");
        return mv;
    }

}
