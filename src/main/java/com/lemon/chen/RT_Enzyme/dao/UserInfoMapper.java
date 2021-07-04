package com.lemon.chen.RT_Enzyme.dao;

import com.lemon.chen.RT_Enzyme.dao.Dto.UserRegisterDto;
import com.lemon.chen.RT_Enzyme.entity.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select(
            "select user_id as userId, user_name as userName, password, role_id as roleId from user_info where user_name = #{userName}"
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

    @Select(
            "select max(user_id) from user_info"
    )
    Integer getLatestUserId();

    @Insert(
            "INSERT user_info VALUES(#{userId}, #{userName}, 3, #{password}, #{email}, #{phoneNumber})"
    )
    Integer insertNormalUserInfo(UserRegisterDto userRegisterDto);

    @Insert(
            "INSERT user_proj_rel VALUES(#{project}, #{userId}, now())"
    )
    Integer insertUserProjRel(UserRegisterDto userRegisterDto);

    @Select(
            "SELECT\n" +
            "    user_id as userId,\n" +
            "    user_name as userName\n" +
            "FROM\n" +
            "    user_info\n" +
            "WHERE\n" +
            "        user_info.role_id = 1"
    )
    List<LinkedHashMap<String, Object>> getAdminList();
}
