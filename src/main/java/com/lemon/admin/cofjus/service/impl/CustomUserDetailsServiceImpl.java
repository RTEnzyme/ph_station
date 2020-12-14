package com.lemon.admin.cofjus.service.impl;


import com.lemon.admin.cofjus.entity.Agent;
import com.lemon.admin.cofjus.repositories.AgentRepository;
import com.lemon.admin.cofjus.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ji Rui
 * @date 2020/7/4
 */
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    Logger logger = LoggerFactory.getLogger(CustomUserDetailsServiceImpl.class);
    @Autowired
    AgentRepository agentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Agent usr = null;
        if(!username.equals("admin")){
            return null;
        }
        usr = agentRepository.findByUserName(username);
        User user = null;
        if(usr != null){
            user = new User(username, usr.getPassword(), true, true, true, true, getAuthority());
            return user;
        }
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(/*List<UserRole> roles*/) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
//        for (UserRole role : roles) {
//            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        list.add(new SimpleGrantedAuthority("ROLE_" + "Admin"));
//        }
        return list;
    }
}
