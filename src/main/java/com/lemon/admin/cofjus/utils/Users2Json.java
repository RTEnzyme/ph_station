package com.lemon.admin.cofjus.utils;

import com.alibaba.fastjson.JSONObject;
import com.lemon.admin.cofjus.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Users2Json {
    public static List<JSONObject> users2Json(List<User> users,String agentName){
        //将各个达人信息加入到json中
        List<JSONObject> jsonObjectList = new ArrayList<>();
        for(User user:users){
            JSONObject json = new JSONObject();;
            json.put("kol_name",user.getKolName());

            if(user.getAvatarUrl()!=null) {
                json.put("AvatarUrl", user.getAvatarUrl());
            }else{
                json.put("AvatarUrl","");
            }

            if(user.getUniqueId()!=null) {
                json.put("douyinId", user.getUniqueId());
            }else{
                json.put("douyinId","");
            }

            if(user.getStarLabel()!=null) {
                json.put("StarLabel", user.getStarLabel());
            }else{
                json.put("StarLabel","");
            }

            if(user.getPrice()!=null) {
                json.put("price", user.getPrice());

            }else{
                json.put("price","");
            }

            if(user.getBeforePrice()!=null) {
                json.put("beforePrice", user.getBeforePrice());
                json.put("beforePriceShow",user.getBeforePrice());
            }else{
                json.put("beforePrice","");
                json.put("beforePriceShow","");
            }

            StringBuffer labels = new StringBuffer();
            if(user.getSelectLabel1()!=null) {
                json.put("Label1", user.getSelectLabel1());
                if(user.getSelectLabel1().length() != 0) {
                    labels.append(user.getSelectLabel1());
                }
            }else{
                json.put("Label1","");
            }

            if(user.getSelectLabel2()!=null) {
                json.put("Label2", user.getSelectLabel2());
                if(user.getSelectLabel2().length()!=0) {
                    labels.append("，");
                    labels.append(user.getSelectLabel2());
                }
            }else{
                json.put("Label2","");
            }

            if(user.getSelectLabel3()!=null) {
                json.put("Label3", user.getSelectLabel3());
                if(user.getSelectLabel3().length()!=0) {
                    labels.append("，");
                    labels.append(user.getSelectLabel3());
                }
            }else{
                json.put("Label3","");
            }
            json.put("label",labels.toString());

            // 合作配合度（高/中/低 下拉菜单）
            if(user.getCooperateDegree()!=null) {
                json.put("CooperateDegree", user.getCooperateDegree());
            }else{
                json.put("CooperateDegree","");
            }

            // 最后标注人（不可改)
            if(user.getLastLabelId()!=null) {
                json.put("LastLabelId", agentName);
            }else{
                json.put("LastLabelId","");
            }
            jsonObjectList.add(json);
        }
        return jsonObjectList;
    }
}
