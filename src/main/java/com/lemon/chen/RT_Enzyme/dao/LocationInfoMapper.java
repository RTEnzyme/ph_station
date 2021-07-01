package com.lemon.chen.RT_Enzyme.dao;

import com.lemon.chen.RT_Enzyme.dao.Dto.LocationDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationInfoMapper {
    @Select(
            "select l.latitude, l.longitude, p.proj_name from location_info l, proj_info j " +
                    "where p.proj_id=#{projId} and p.location_id = l.location_id"
    )
    List<LocationDto> getLocationInfosByProjId(Integer projId);
}
