package com.lemon.admin.cofjus.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.admin.cofjus.entity.User;
import com.lemon.admin.cofjus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.html");
        return mv;
    }
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.html");
        return mv;
    }
    @RequestMapping("/main")
    public ModelAndView main(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main.html");
        return mv;
    }
    @RequestMapping("/brandList")
    @ResponseBody
    public String brandList(){
        List<User> brands = userRepository.findAll();
        List<JSONObject> jsonObjectList = new ArrayList<>();
        for(User brand:brands){
            //将数据加入到json中
            JSONObject json = new JSONObject();;
//            json.put("avator_url",agent.getAvatar_url().replace(".webp",".png"));
            json.put("kol_name",brand.getKolName());
            // KOL头像，用户名，抖音号，星图标签（不可改），星图价格（不可改），

            if(brand.getAvatarUrl()!=null) {
                json.put("AvatarUrl", brand.getAvatarUrl());
            }else{
                json.put("AvatarUrl","");
            }

            if(brand.getUniqueId()!=null) {
                json.put("douyinId", brand.getUniqueId());
            }else{
                json.put("douyinId","");
            }

            if(brand.getStarLabel()!=null) {
                json.put("StarLabel", brand.getStarLabel());
            }else{
                json.put("StarLabel","");
            }

            if(brand.getPrice()!=null) {
                json.put("price", brand.getPrice());
            }else{
                json.put("price","");
            }

            if(brand.getBeforePrice()!=null) {
                json.put("beforePrice", brand.getBeforePrice());
            }else{
                json.put("beforePrice","");
            }

            // 标注选单一（文本框+下拉），标注选单二，标注选单三，过往合作价格（可改），
            // 合作配合度（高中低），最后标注人（不可改)

            jsonObjectList.add(json);
        }
        //生成Layui.table需要的数据格式
        JSONObject jsonContainer = new JSONObject();
        jsonContainer.put("data",jsonObjectList);
        jsonContainer.put("code",0);
        jsonContainer.put("message","");
        jsonContainer.put("count",brands.size());
        return jsonContainer.toJSONString();
    }

}
