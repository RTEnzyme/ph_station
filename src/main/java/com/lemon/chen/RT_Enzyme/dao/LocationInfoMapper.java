package com.lemon.chen.RT_Enzyme.dao;

import com.lemon.chen.RT_Enzyme.dao.Dto.ChartV1Dto;
import com.lemon.chen.RT_Enzyme.dao.Dto.LocationDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface LocationInfoMapper {
    @Select(
            "SELECT\n" +
            "   latitude, longitude, proj_name as projName\n" +
            "FROM\n" +
            "   user_proj_rel\n" +
            "   JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id\n" +
            "   JOIN location_info ON proj_info.location_id = location_info.location_id \n" +
            "WHERE\n" +
            "   user_id =#{uid}"
    )
    List<LocationDto> getLocationInfosByProjId(Integer uid);

    @Select(
            "SELECT\n" +
            "   proj_name AS projName,\n" +
            "   IFNULL(avg_temp, 0) AS avgTemp,\n" +
            "   IFNULL(max_depth, 0) AS maxDepth,\n" +
            "   IFNULL(avg_speed, 0) AS avgSpeed,\n" +
            "   IFNULL(storm_days, 0) AS stormDays \n" +
            "FROM\n" +
            "   user_proj_rel\n" +
            "   JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id\n" +
            "   JOIN location_info ON location_info.location_id = proj_info.location_id\n" +
            "   JOIN met_info ON met_info.met_id = location_info.met_id \n" +
            "WHERE\n" +
            "   user_proj_rel.user_id =#{uid}"
    )
    List<ChartV1Dto> getchartInfoByUid(Integer uid);

}
