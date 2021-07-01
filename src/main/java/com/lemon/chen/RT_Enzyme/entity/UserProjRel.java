package com.lemon.chen.RT_Enzyme.entity;


import lombok.Data;

import java.util.Date;

@Data
public class UserProjRel {

    Integer projId;

    Integer userId;

    Date createDate;

}
