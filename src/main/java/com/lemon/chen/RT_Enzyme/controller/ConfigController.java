package com.lemon.chen.RT_Enzyme.controller;

import com.lemon.chen.RT_Enzyme.dao.Dto.Result;
import com.lemon.chen.RT_Enzyme.dao.Dto.UserRegisterDto;
import com.lemon.chen.RT_Enzyme.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/config")
@ResponseBody
public class ConfigController {

    @Autowired
    UserService userService;

    @PostMapping("/password")
    public int mySubmit(@RequestBody String password) {
        return userService.updatePassword(password);
    }

    @PostMapping("/{uid}/user")
    public Result<Integer> createUser(@RequestBody UserRegisterDto userRegisterDto){
        System.out.println(userRegisterDto);
        Integer res = userService.userRegister(userRegisterDto);
        return new Result<>(res);
    }
}