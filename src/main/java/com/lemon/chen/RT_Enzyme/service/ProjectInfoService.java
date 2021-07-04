package com.lemon.chen.RT_Enzyme.service;

import com.lemon.chen.RT_Enzyme.dao.ProjInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ProjectInfoService {

    @Resource
    ProjInfoMapper projInfoMapper;

    public Map<String, Float> getAvgData(Integer uid){
        return projInfoMapper.getAvgProjInfo(uid);
    }

    public LinkedHashMap<String, Object> getProjInfoByProjId(Integer projId){
        return projInfoMapper.getProjectInfoByProjId(projId);
    }

}
