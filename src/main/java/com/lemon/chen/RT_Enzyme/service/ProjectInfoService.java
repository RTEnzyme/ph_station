package com.lemon.chen.RT_Enzyme.service;

import com.lemon.chen.RT_Enzyme.dao.Dto.TransDto;
import com.lemon.chen.RT_Enzyme.dao.ProjInfoMapper;
import com.lemon.chen.RT_Enzyme.entity.ProjInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
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

    public Integer getProjForUser(Integer uid) { return projInfoMapper.getProjListByUid(uid).get(0).getProjId(); }

    public List<TransDto> adminProjectList(){ return projInfoMapper.adminProjList();}

    public List<String> authedProjIds(Integer uid){ return projInfoMapper.authedProjList(uid);}

}
