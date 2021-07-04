package com.lemon.chen.RT_Enzyme.service;


import com.alibaba.fastjson.JSONArray;
import com.lemon.chen.RT_Enzyme.dao.Dto.ChartV1Dto;
import com.lemon.chen.RT_Enzyme.dao.LocationInfoMapper;
import com.lemon.chen.RT_Enzyme.dao.ProjInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ChartService {

    @Resource
    LocationInfoMapper locationInfoMapper;

    @Resource
    ProjInfoMapper projInfoMapper;

    public List<ChartV1Dto> chartInfo(Integer uid){
        return locationInfoMapper.getchartInfoByUid(uid);
    }

    public List<LinkedHashMap<String, Object>> tableInfo(Integer uid) { return projInfoMapper.getTableInfoByUid(uid);}
}
