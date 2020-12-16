package com.lemon.admin.cofjus.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.admin.cofjus.entity.User;
import com.lemon.admin.cofjus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String brandList(Integer limit,Integer page,String kol_name,String douyinId){
        List<User> brands;
        List<JSONObject> jsonObjectList = new ArrayList<>();
        if(kol_name != null && !kol_name.equals("")){
//             System.out.println(kol_name);
//             System.out.println(douyinId);
            brands = userRepository.findUsersByKolName(kol_name);
        }else if(douyinId != null ){
            brands = userRepository.findUsersByUniqueId(douyinId);
        }else {
            brands = userRepository.findAll().subList(0,100);
        }

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

            // 过往合作价格 1-20s（文本框，只能填数字）
            if(brand.getBeforePrice()!=null) {
                json.put("beforePrice", brand.getBeforePrice());
            }else{
                json.put("beforePrice","");
            }


            // 过往合作价格 20-60（文本框，只能填数字）
            if(brand.getBeforePrice2()!=null) {
                json.put("beforePrice2", brand.getBeforePrice2());
            }else{
                json.put("beforePrice2","");
            }

            // 标签1（文本框+下拉菜单），标签2（文本框+下拉菜单），标签3（文本框+下拉菜单）
            // 标签1，2，3的下拉菜单来自 lable表中的50个标签

            if(brand.getSelectLabel1()!=null) {
                json.put("Label1", brand.getSelectLabel1());
            }else{
                json.put("Label1","");
            }

            if(brand.getSelectLabel2()!=null) {
                json.put("Label2", brand.getSelectLabel2());
            }else{
                json.put("Label2","");
            }

            if(brand.getSelectLabel3()!=null) {
                json.put("Label3", brand.getSelectLabel3());
            }else{
                json.put("Label3","");
            }

            if(brand.getCooperateDegree()!=null) {
                json.put("CooperateDegree", brand.getCooperateDegree());
            }else{
                json.put("CooperateDegree","");
            }
            // 合作配合度（高/中/低 下拉菜单）

            if(brand.getLastLabelId()!=null) {
                json.put("LastLabelId", brand.getLastLabelId());
            }else{
                json.put("LastLabelId","");
            }

            // 最后标注人（不可改)

            jsonObjectList.add(json);
        }
        int size=jsonObjectList.size();
        if(page*limit<=size){
            jsonObjectList=jsonObjectList.subList((page-1)*limit, page*limit);
        }else{
            jsonObjectList=jsonObjectList.subList((page-1)*limit, size);
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

