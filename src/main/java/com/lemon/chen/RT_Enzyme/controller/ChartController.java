package com.lemon.chen.RT_Enzyme.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lemon.chen.RT_Enzyme.dao.Dto.Table;
import com.lemon.chen.RT_Enzyme.dao.Dto.TransDto;
import com.lemon.chen.RT_Enzyme.service.ChartService;
import com.lemon.chen.RT_Enzyme.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/chart")
public class ChartController {

    @Autowired
    ChartService chartService;

    @Autowired
    ProjectInfoService projectInfoService;

    @GetMapping("/{uid}/v1")
    public JSONObject avgTempChart(@PathVariable Integer uid){
        JSONObject json = new JSONObject();
        json.put("chart", chartService.chartInfo(uid));
        return json;
    }

    @GetMapping("/{uid}/table")
    public Table<List<LinkedHashMap<String, Object>>> projTable(@PathVariable Integer uid){
        List<LinkedHashMap<String, Object>> maps = chartService.tableInfo(uid);
        Table<List<LinkedHashMap<String, Object>>> table = new Table<>(chartService.tableInfo(uid));
        table.setCount(maps.size());
        return table;
    }



}
