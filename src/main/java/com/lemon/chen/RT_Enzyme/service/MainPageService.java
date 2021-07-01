package com.lemon.chen.RT_Enzyme.service;

import com.lemon.chen.RT_Enzyme.dao.Dto.LocationDto;
import com.lemon.chen.RT_Enzyme.dao.LocationInfoMapper;
import com.lemon.chen.RT_Enzyme.dao.ProjInfoMapper;
import com.lemon.chen.RT_Enzyme.entity.ProjInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MainPageService {

    @Resource
    LocationInfoMapper locationInfoMapper;

    @Resource
    ProjInfoMapper projInfoMapper;

    public List<LocationDto> locations_list(Integer proj_id){
        return locationInfoMapper.getLocationInfosByProjId(proj_id);
    }

    public List<ProjInfo> projInfoList(Integer uid){
        return projInfoMapper.getProjListByUid(uid);
    }
}
