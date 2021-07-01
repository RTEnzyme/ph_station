package com.lemon.admin.RT_Enzyme.controller;

import com.lemon.admin.RT_Enzyme.dao.RoleInfoMapper;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@ResponseBody
public class MainController {
    @Resource
    RoleInfoMapper roleInfoMapper;

    @GetMapping("/test")
    public String test(){
        return roleInfoMapper.testMapper();
    }

    @GetMapping("/main/page")
    public ModelAndView mainPage(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.html");
        return mv;
    }

}

