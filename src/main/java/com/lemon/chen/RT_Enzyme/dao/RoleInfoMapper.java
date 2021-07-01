package com.lemon.chen.RT_Enzyme.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoleInfoMapper {
    @Select(
            "select role_code from role_info where role_id = 1"
    )
    String testMapper();
}
