package com.lemon.admin.cofjus.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.admin.cofjus.entity.Label;
import com.lemon.admin.cofjus.entity.Operator;
import com.lemon.admin.cofjus.entity.User;
import com.lemon.admin.cofjus.repositories.LabelRepository;
import com.lemon.admin.cofjus.repositories.OperatorRepository;
import com.lemon.admin.cofjus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.text.Collator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    OperatorRepository operatorRepository;

    @Autowired
    LabelRepository labelRepository;

    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login.html");
        return mv;
    }
//    @RequestMapping("/index")
//    public ModelAndView index(){
//        ModelAndView mv = new ModelAndView();
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User)principal;
//        mv.addObject("username",usr.getUsername());
//        mv.setViewName("index.html");
//        return mv;
//    }
    @RequestMapping("/")
    public ModelAndView main() throws ParseException {
        ModelAndView mv = new ModelAndView();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User)principal;
        Operator agent = operatorRepository.findByUserName(usr.getUsername());
        mv.addObject("labeled_count",agent.getLabeledCount());
        mv.addObject("update_count",agent.getUpdateCount());
        mv.addObject("username",agent.getUserName());
        //当天日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(date.getTime());

        ArrayList<User> todayUsers = new ArrayList<>();
        List<User> users = userRepository.findByLastLabelId(agent.getId());
        if (users.size()>0) {
            for (User user : users) {
                if (user.getLastLabelTime().getTime() > simpleDateFormat.parse(today).getTime()) {
                    todayUsers.add(user);
                }
            }
        }

        mv.addObject("todayCount", todayUsers.size());
        mv.setViewName("main.html");
        return mv;
    }
    @RequestMapping("/brandList")
    @ResponseBody
    public String brandList(Integer limit,Integer page/**,String kol_name*/,String douyinId){
        List<User> brands;
        List<JSONObject> jsonObjectList = new ArrayList<>();
//        if(kol_name != null && !kol_name.equals("")){
//             System.out.println(kol_name);
//             System.out.println(douyinId);
//            brands = userRepository.findUsersByKolName(kol_name);
//        }else
        if(douyinId != null ){
            brands = userRepository.findUsersByUniqueId(douyinId);
            if(brands.size() == 0){
                brands = userRepository.findUsersByKolName(douyinId);
            }
        }else {
            // TODO each operator has different view
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) principal;
            Operator agent = operatorRepository.findByUserName(currentUser.getUsername());
            int startIndex = agent.getId().intValue() - 1;
            int start = 0;
            int end = 0;
            // int totalUsers = (int)userRepository.count();
            //  if (startIndex)
            // brands = userRepository.cascadeQuery().subList(0,20);
            int totalNum = (int) userRepository.count();
            if (startIndex * 200 >= totalNum) {
                start = 0;
            } else {
                start = startIndex * 200;
            }

            if (start + 200 >= totalNum) {
                end = totalNum;
            } else {
                end = start + 200;
            }

            brands = userRepository.findUsersByLastLabelId().subList(start, end);
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
                json.put("beforePriceShow",brand.getBeforePrice());
            }else{
                json.put("beforePrice","");
                json.put("beforePriceShow","");
            }


//            // 过往合作价格 20-60（文本框，只能填数字）
//            if(brand.getBeforePrice2()!=null) {
//                json.put("beforePrice2", brand.getBeforePrice2());
//            }else{
//                json.put("beforePrice2","");
//            }

            // 标签1（文本框+下拉菜单），标签2（文本框+下拉菜单），标签3（文本框+下拉菜单）
            // 标签1，2，3的下拉菜单来自 lable表中的50个标签
            StringBuffer labels = new StringBuffer();
            if(brand.getSelectLabel1()!=null) {
                json.put("Label1", brand.getSelectLabel1());
                if(brand.getSelectLabel1().length() != 0) {
                    labels.append(brand.getSelectLabel1());
                }
            }else{
                json.put("Label1","");
            }

            if(brand.getSelectLabel2()!=null) {
                json.put("Label2", brand.getSelectLabel2());
                if(brand.getSelectLabel2().length()!=0) {
                    labels.append("，");
                    labels.append(brand.getSelectLabel2());
                }
            }else{
                json.put("Label2","");
            }

            if(brand.getSelectLabel3()!=null) {
                json.put("Label3", brand.getSelectLabel3());
                if(brand.getSelectLabel3().length()!=0) {
                    labels.append("，");
                    labels.append(brand.getSelectLabel3());
                }
            }else{
                json.put("Label3","");
            }
            json.put("label",labels.toString());
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
    @RequestMapping("/autocomplete")
    @ResponseBody
    public String autocomplete(){
        List<String> keys = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user:users){
            keys.add(user.getKolName());
            keys.add(user.getUniqueId());
        }
        JSONObject json = new JSONObject();
        json.put("data",keys);
        return  json.toJSONString();
    }
    @RequestMapping("/labelcontent")
    @ResponseBody
    public String labelcontent(){
        List<Label> labels = labelRepository.findAll();
        Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);
        List<String> keys = new ArrayList<>();
        for(Label label:labels){
            keys.add(label.getType());
//            keys.add(user.getUniqueId());
        }
        keys.sort(cmp);
        JSONObject json = new JSONObject();
        json.put("data",keys);
        return  json.toJSONString();
    }
    @RequestMapping("/update_user/")
    @ResponseBody
    public String update_user(@RequestParam("kol_name") String kol_name, @RequestParam(value = "before_price",defaultValue = "") String before_price,  @RequestParam(value = "CooperateDegree",defaultValue = "") String CooperateDegree, @RequestParam(value = "Label1",defaultValue = "") String Label1,
                            @RequestParam(value = "Label2",defaultValue = "") String Label2, @RequestParam(value = "Label3",defaultValue = "") String Label3){
//        System.out.println("test"+kol_name);

        User usr = userRepository.findUsersByKolName(kol_name).get(0);
        usr.setBeforePrice(before_price);
        usr.setCooperateDegree(CooperateDegree);
        usr.setSelectLabel1(Label1);
        usr.setSelectLabel2(Label2);
        usr.setSelectLabel3(Label3);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User)principal;
        Operator agent = operatorRepository.findByUserName(currentUser.getUsername());

        // KOL没有被标注
        if (usr.getLastLabelId() == null){
            usr.setLastLabelId(agent.getId());
            Date updateDate = Calendar.getInstance().getTime();
            usr.setLastLabelTime(updateDate);
            agent.setLabeledCount(agent.getLabeledCount() + 1 );
            operatorRepository.save(agent);
        }
        // KOL 已经被标注
        else
        {
            // 自己修改，无操作
            if (usr.getLastLabelId().intValue() == agent.getId()){

            }
            // 修改了别人的记录
            else{
                Operator preAgent = operatorRepository.findById(usr.getLastLabelId().intValue());
                usr.setPreLabelId(usr.getLastLabelId());
                usr.setPreLabelTime(usr.getLastLabelTime());
                preAgent.setUpdateCount(preAgent.getUpdateCount() +1);
                operatorRepository.save(preAgent);

                usr.setLastLabelId(agent.getId());
                Date updateDate = Calendar.getInstance().getTime();
                usr.setLastLabelTime(updateDate);
                agent.setLabeledCount(agent.getLabeledCount() + 1 );
                operatorRepository.save(agent);
            }
        }

        userRepository.save(usr);
        JSONObject json = new JSONObject();
        json.put("flag","success");
        return json.toJSONString();
    }
}

