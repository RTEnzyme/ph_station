package com.lemon.chen.RT_Enzyme.service;

import com.lemon.chen.RT_Enzyme.dao.UserInfoMapper;
import com.lemon.chen.RT_Enzyme.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public Integer updatePassword(String password){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User usr = (User)principal;
        String userName = usr.getUsername();
        String psd = Md5Util.encodePassword(password);
        return userInfoMapper.updatePasswordByUserName(userName, psd);
    }


}
