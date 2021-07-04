package com.lemon.chen.RT_Enzyme.service;

import com.lemon.chen.RT_Enzyme.dao.UserInfoMapper;
import com.lemon.chen.RT_Enzyme.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class RoleService {
    @Resource
    UserInfoMapper userInfoMapper;

    public String mainPageByRole(String user_name){
        UserInfo usr = userInfoMapper.findUserInfoByUserName(user_name);
        if (usr.getRoleId() == 1) return "index_admin.html";
        else if (usr.getRoleId() == 2) return "index_super_admin.html";
        else return "index.html";
    }

    public List<LinkedHashMap<String, Object>> getAdminList(){
        return userInfoMapper.getAdminList();
    }
}
