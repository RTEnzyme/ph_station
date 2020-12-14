package com.lemon.admin.cofjus.controller;

import com.lemon.admin.cofjus.entity.Agent;
import com.lemon.admin.cofjus.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mySubmit")
public class MySubmitController {

    @Autowired
    private AgentRepository agentRepository;

    @ResponseBody
    @RequestMapping(value = "/changeInformation", method = RequestMethod.POST)
    public int mySubmit(@RequestBody Map<String,String> reqMap) {

        Agent agent = agentRepository.findByUserName("admin");
//        String phone = reqMap.get("phone");
        String password =encodePassword(reqMap.get("password"));
//        String mailbox = reqMap.get("mailbox");
        agent.setPassword(password);
//        agent1.setPhone(phone);
//        agent.setEmail(mailbox);
        //        Map<String,String> mymap = new HashMap<>();
//        mymap.put("username",username);
//        mymap.put("phone",phone);
//        mymap.put("password",password);
//        mymap.put("mailbox",mailbox);
        agentRepository.save(agent);
        int res = 1;
        return res;

    }

    private static final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
}