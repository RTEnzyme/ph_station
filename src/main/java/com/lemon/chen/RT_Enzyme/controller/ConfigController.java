package com.lemon.chen.RT_Enzyme.controller;

import com.lemon.chen.RT_Enzyme.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    PasswordService passwordService;

    @ResponseBody
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public int mySubmit(@RequestBody String password) {
        return passwordService.updatePassword(password);
    }

}