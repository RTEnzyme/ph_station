package com.lemon.chen.RT_Enzyme.dao;

import com.lemon.chen.RT_Enzyme.dao.Dto.TransDto;
import com.lemon.chen.RT_Enzyme.entity.ProjInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ProjInfoMapper {

    @Select(
            "SELECT\n" +
            "    proj_info.proj_id as projId,\n" +
            "    proj_name as projName,\n" +
            "    state,\n" +
            "    owner_id as ownerId,\n" +
            "    design_institute as designInstitute,\n" +
            "    date,\n" +
            "    location_id as locationId\n" +
            "FROM\n" +
            "    user_proj_rel\n" +
            "    JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id\n" +
            "WHERE\n" +
            "    user_proj_rel.user_id = #{uid}"
    )
    List<ProjInfo> getProjListByUid(Integer uid);

    @Select(
            "SELECT\n" +
            "    ROUND(AVG(avg_temp), 2) AS avgTemp,\n" +
            "    ROUND(AVG(max_depth), 2) AS avgDepth,\n" +
            "    ROUND(AVG(avg_speed), 2) AS avgSpeed,\n" +
            "    ROUND(AVG(storm_days), 2) AS avgStormDays\n" +
            "FROM\n" +
            "    user_proj_rel\n" +
            "        JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id\n" +
            "        JOIN location_info ON location_info.location_id = proj_info.location_id\n" +
            "        JOIN met_info ON met_info.met_id = location_info.met_id\n" +
            "WHERE\n" +
            "        user_proj_rel.user_id =#{uid}"
    )
    Map<String, Float> getAvgProjInfo(Integer uid);

    @Select(
            "SELECT\n" +
            "    proj_info.proj_id as projId,\n" +
            "    proj_name as projName,\n" +
            "    proj_type as projType,\n" +
            "    state,\n" +
            "    date,\n" +
            "    design_institute as designInstitute\n" +
            "FROM\n" +
            "    user_proj_rel\n" +
            "    JOIN proj_info ON user_proj_rel.proj_id = proj_info.proj_id\n" +
            "WHERE\n" +
            "    user_proj_rel.user_id =#{uid}"
    )
    List<LinkedHashMap<String, Object>> getTableInfoByUid(Integer uid);

    @Select(
            "SELECT\n" +
            "    *\n" +
            "FROM\n" +
            "    proj_info\n" +
            "        JOIN location_info ON location_info.location_id = proj_info.proj_id\n" +
            "        JOIN met_info ON met_info.met_id = location_info.met_id\n" +
            "WHERE\n" +
            "        proj_id = #{projId}"
    )
    LinkedHashMap<String, Object> getProjectInfoByProjId(Integer projId);

    @Select(
            "SELECT\n" +
            "    proj_id as value,\n" +
            "    proj_name as title\n" +
            "FROM\n" +
            "    proj_info\n"
    )
    List<TransDto> adminProjList();

    @Select(
            "SELECT\n" +
            "   proj_id\n" +
            "FROM\n" +
            "   user_proj_rel\n" +
            "WHERE\n" +
            "   user_proj_rel.user_id = #{uid}"
    )
    List<String> authedProjList(Integer uid);
}
