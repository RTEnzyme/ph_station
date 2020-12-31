package com.lemon.admin.cofjus.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.admin.cofjus.entity.Label;
import com.lemon.admin.cofjus.entity.Operator;
import com.lemon.admin.cofjus.entity.User;
import com.lemon.admin.cofjus.repositories.LabelRepository;
import com.lemon.admin.cofjus.repositories.OperatorRepository;
import com.lemon.admin.cofjus.repositories.UserRepository;
import com.lemon.admin.cofjus.utils.Users2Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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


    @RequestMapping("/index")
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
        if(agent.getPage()!=null) {
            mv.addObject("page", agent.getPage());
        }else{
            mv.addObject("page",1);
        }
        mv.addObject("todayCount", todayUsers.size());
        mv.setViewName("main.html");
        return mv;
    }

    @RequestMapping("/brandList")
    @ResponseBody
    public String brandList(Integer limit,Integer page/**,String kol_name*/,String douyinId){
        List<User> users;
        //获取当前用户
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) principal;
        Operator agent = operatorRepository.findByUserName(currentUser.getUsername());

        if(douyinId != null ){
            users = userRepository.findUsersByUniqueId(douyinId);
            if(users.size() == 0){
                users = userRepository.findUsersByKolName(douyinId);
            }
        }else {
            users = userRepository.findByOperatorId(agent.getId());
        }

        List<JSONObject> jsonObjectList = Users2Json.users2Json(users,agent.getUserName());
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
        jsonContainer.put("count",users.size());
        return jsonContainer.toJSONString();
    }
    @RequestMapping("/autocomplete")
    @ResponseBody
    public String autocomplete(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User) principal;
        Operator agent = operatorRepository.findByUserName(currentUser.getUsername());
        List<String> keys = new ArrayList<>();
        List<User> users = userRepository.findByOperatorId(agent.getId());
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
        // 按照拼音排序
        List<Label> labels = labelRepository.findAll();
        Comparator cmp = Collator.getInstance(java.util.Locale.CHINA);
        List<String> keys = new ArrayList<>();
        for(Label label:labels){
            keys.add(label.getType());
        }
        keys.sort(cmp);
        JSONObject json = new JSONObject();
        json.put("data",keys);
        return  json.toJSONString();
    }
    @RequestMapping("/update_user/")
    @ResponseBody
    public JSONObject update_user(@RequestParam("kol_name") String kol_name, @RequestParam(value = "beforePrice",defaultValue = "") String before_price,  @RequestParam(value = "CooperateDegree",defaultValue = "") String CooperateDegree, @RequestParam(value = "Label1",defaultValue = "") String Label1,
                            @RequestParam(value = "Label2",defaultValue = "") String Label2, @RequestParam(value = "Label3",defaultValue = "") String Label3,@RequestParam(value="page",defaultValue = "1") Integer page){

        JSONObject json = new JSONObject();
        User usr = userRepository.findUsersByKolName(kol_name).get(0);

        usr.setBeforePrice(before_price);
        usr.setCooperateDegree(CooperateDegree);
        usr.setSelectLabel1(Label1);
        usr.setSelectLabel2(Label2);
        usr.setSelectLabel3(Label3);
        //获取当前用户
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User currentUser = (org.springframework.security.core.userdetails.User)principal;
        Operator agent = operatorRepository.findByUserName(currentUser.getUsername());
        agent.setPage(page);
        // KOL没有被标注
        if (usr.getLastLabelId() == null){
            usr.setLastLabelId(agent.getId());
            Date updateDate = Calendar.getInstance().getTime();
            usr.setLastLabelTime(updateDate);
            agent.setLabeledCount(agent.getLabeledCount() + 1 );
            operatorRepository.save(agent);
            json.put("status",1);
        }
        // KOL 已经被标注
        else
        {
            // 自己修改，无操作
            if (usr.getLastLabelId().intValue() == agent.getId()){
                json.put("status",0);
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

                json.put("status",0);
            }
        }
        userRepository.save(usr);
        return json;
    }
}

