package com.lemon.admin.cofjus.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.admin.cofjus.entity.Brand;
import com.lemon.admin.cofjus.repositories.BrandRepository;
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
    BrandRepository brandRepository;
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
        List<Brand> brands = brandRepository.findAll();
        List<JSONObject> jsonObjectList = new ArrayList<>();
        for(Brand brand:brands){
            //将数据加入到json中
            JSONObject json = new JSONObject();;
//            json.put("avator_url",agent.getAvatar_url().replace(".webp",".png"));
            json.put("brand_name",brand.getName());
            if(brand.getTrader_count()!=null) {
                json.put("trader_count", brand.getTrader_count());
            }else{
                json.put("trader_count","");
            }
            if(brand.getLive_trader_count()!=null) {
                json.put("live_trader_count", brand.getLive_trader_count());
            }else{
                json.put("live_trader_count","");
            }
            if(brand.getUpdate_time()!=null) {
                json.put("update_time", brand.getUpdate_time());
            }else{
                json.put("update_time","");
            }
            if(brand.getUsername()!=null) {
                json.put("username", brand.getUsername());
            }else{
                json.put("username","");
            }
            if(brand.getPassword()!=null) {
                json.put("password", brand.getPassword());
            }else{
                json.put("password","");
            }
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

