package com.lemon.chen.RT_Enzyme.dao;

import com.lemon.chen.RT_Enzyme.entity.ProjInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjInfoMapper {
    @Select(
            "select * from user_proj_rel upr join proj_info pi on upr.poj_id=pi.proj_id " +
                    "where upr.user_id = #{uid}"
    )
    List<ProjInfo> getProjListByUid(Integer uid);
}
