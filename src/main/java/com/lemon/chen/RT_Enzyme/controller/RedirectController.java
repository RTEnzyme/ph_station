package com.lemon.chen.RT_Enzyme.controller;

import com.lemon.chen.RT_Enzyme.service.ProjectInfoService;
import com.lemon.chen.RT_Enzyme.service.RoleService;
import com.lemon.chen.RT_Enzyme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/url")
public class RedirectController {

    @Autowired
    RoleService roleService;

    @Autowired
    ProjectInfoService projectInfoService;

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public ModelAndView mainPage(){
        // 通过SpringSecurty获取用户名
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User usr = (User)principal;
        ModelAndView mv = new ModelAndView();
        mv.addObject("uid", userService.findUserIdByUsername(usr.getUsername()));
        mv.setViewName(roleService.mainPageByRole(usr.getUsername()));
        return mv;
    }

    @GetMapping("/main/{uid}")
    public ModelAndView homePage(@PathVariable Integer uid){
        ModelAndView mv = new ModelAndView();
        mv.addObject("uid", uid);
        mv.setViewName("main1.html");
        return  mv;
    }

    @GetMapping("/statistic/{uid}")
    public ModelAndView statisticPage(@PathVariable Integer uid){
        Map<String, Float> avgData = projectInfoService.getAvgData(uid);
        ModelAndView mv = new ModelAndView();
        mv.addObject("uid", uid);
        mv.setViewName("dataCollection.html");
        mv.addAllObjects(avgData);
        return mv;
    }

    @GetMapping("/project/{proj_id}")
    public ModelAndView projectPage(@PathVariable Integer proj_id){
        LinkedHashMap<String, Object> info = projectInfoService.getProjInfoByProjId(proj_id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("proj_id", proj_id);
        mv.addAllObjects(info);
        mv.setViewName("/console.html");
        return mv;
    }

    @GetMapping("/{uid}/project")
    public ModelAndView projectPageForUser(@PathVariable Integer uid){
        // 获取用户关联的proj_id
        Integer projId = projectInfoService.getProjForUser(uid);
        LinkedHashMap<String, Object> info = projectInfoService.getProjInfoByProjId(projId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("uid", uid);
        mv.addAllObjects(info);
        mv.setViewName("/console.html");
        return mv;
    }

    @GetMapping("/create_user/{uid}")
    public ModelAndView createProj(@PathVariable Integer uid){
        ModelAndView mv = new ModelAndView();
        mv.addObject("uid", uid);
        mv.setViewName("create_user.html");
        return mv;
    }

    @GetMapping("/project/admin")
    public ModelAndView projectAdmin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("project_distribute.html");
        return mv;
    }
}
