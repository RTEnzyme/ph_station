package com.lemon.admin.RT_Enzyme.dao;

import com.lemon.admin.RT_Enzyme.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    @Select(
            "select * from user_info where user_name = #{userName}"
    )
    UserInfo findUserInfoByUserName(String userName);
}
