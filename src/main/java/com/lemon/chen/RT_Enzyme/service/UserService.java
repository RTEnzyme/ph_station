package com.lemon.chen.RT_Enzyme.service;

import com.lemon.chen.RT_Enzyme.dao.Dto.UserRegisterDto;
import com.lemon.chen.RT_Enzyme.dao.UserInfoMapper;
import com.lemon.chen.RT_Enzyme.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public Integer updatePassword(String password){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User usr = (User)principal;
        String userName = usr.getUsername();
        String psd = Md5Util.encodePassword(password);
        return userInfoMapper.updatePasswordByUserName(userName, psd);
    }

    @Transactional
    public Integer userRegister(UserRegisterDto userInfo){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String cryptPassword = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setUserId(userInfoMapper.getLatestUserId() + 1);
        userInfo.setPassword(cryptPassword);
        // 插入用户信息
        userInfoMapper.insertNormalUserInfo(userInfo);
        // 插入项目关联信息
        userInfoMapper.insertUserProjRel(userInfo);
        return 1;
    }

    public Integer findUserIdByUsername(String userName){ return userInfoMapper.findUserInfoByUserName(userName).getUserId();}
}
