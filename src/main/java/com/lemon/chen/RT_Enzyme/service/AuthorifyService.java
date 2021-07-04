package com.lemon.chen.RT_Enzyme.service;

import com.lemon.chen.RT_Enzyme.dao.UserInfoMapper;
import com.lemon.chen.RT_Enzyme.entity.UserInfo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorifyService implements UserDetailsService {

    @Resource
    UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo usr = null;
        usr = userInfoMapper.findUserInfoByUserName(username);
        User user = null;
        if(usr != null){
            user = new User(username, usr.getPassword(), true, true, true, true, getAuthority());
            return user;
        }
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_" + "Admin"));
        return list;
    }
}
