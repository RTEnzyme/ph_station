package com.lemon.chen.RT_Enzyme.dao.Dto;

import lombok.Data;

@Data
public class UserRegisterDto {

    Integer userId = 0;

    String userName;

    String password;

    Integer project;

    String email;

    String phoneNumber;

    Integer sex;

}
