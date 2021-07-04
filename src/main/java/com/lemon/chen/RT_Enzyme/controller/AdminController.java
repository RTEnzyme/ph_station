package com.lemon.chen.RT_Enzyme.controller;

import com.alibaba.fastjson.JSONObject;
import com.lemon.chen.RT_Enzyme.dao.Dto.TransDto;
import com.lemon.chen.RT_Enzyme.service.ProjectInfoService;
import com.lemon.chen.RT_Enzyme.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
@ResponseBody
public class AdminController {

    @Autowired
    RoleService roleService;

    @Autowired
    ProjectInfoService projectInfoService;

    @GetMapping("/list")
    public JSONObject adminList(){
        JSONObject json = new JSONObject();
        json.put("data", roleService.getAdminList());
        return json;
    }

    @GetMapping("/{uid}/project/list")
    public JSONObject adminProjectList(@PathVariable Integer uid){
        List<TransDto> transDtos = projectInfoService.adminProjectList();
        JSONObject json = new JSONObject();
        json.put("data", transDtos);
        json.put("auth", projectInfoService.authedProjIds(uid));
        return json;
    }

}
