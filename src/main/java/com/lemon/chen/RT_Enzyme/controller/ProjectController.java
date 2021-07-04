package com.lemon.chen.RT_Enzyme.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.chen.RT_Enzyme.dao.Dto.LocationDto;
import com.lemon.chen.RT_Enzyme.entity.ProjInfo;
import com.lemon.chen.RT_Enzyme.service.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class ProjectController {
    @Autowired
    MainPageService mainPageService;



    @GetMapping("/locations/{uid}/list")
    public JSONObject locations_list(@PathVariable("uid")Integer uid){
        JSONObject json = new JSONObject();
        json.put("data",  mainPageService.locations_list(uid));
        return json;
    }

    @GetMapping("/project/{uid}/info")
    public JSONObject projInfoList(@PathVariable("uid")Integer uid){
        JSONObject json = new JSONObject();
        json.put("data", mainPageService.projInfoList(uid));
        return json;
    }

}

