package com.lemon.chen.RT_Enzyme.dao;

import com.lemon.chen.RT_Enzyme.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserInfoMapper {

    @Select(
            "select * from user_info where user_name = #{userName}"
    )
    UserInfo findUserInfoByUserName(String userName);

    @Update(
            "update user_info set password=#{password} where user_name = #{userName}"
    )
    Integer updatePasswordByUserName(String userName, String password);

    @Select(
            "select * from user_info where user_id = #{user_id}"
    )
    UserInfo findUserByUserId(Integer user_id);
}
