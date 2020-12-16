package com.lemon.admin.cofjus.controller;

import com.lemon.admin.cofjus.entity.Operator;
import com.lemon.admin.cofjus.repositories.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/mySubmit")
public class MySubmitController {

    @Autowired
    private OperatorRepository operatorRepository;

    @ResponseBody
    @RequestMapping(value = "/changeInformation", method = RequestMethod.POST)
    public int mySubmit(@RequestBody Map<String,String> reqMap) {

        Operator agent = operatorRepository.findByUserName("admin");
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
        operatorRepository.save(agent);
        int res = 1;
        return res;

    }

    private static final BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }
}