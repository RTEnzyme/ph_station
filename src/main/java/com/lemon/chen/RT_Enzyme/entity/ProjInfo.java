package com.lemon.chen.RT_Enzyme.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ProjInfo {

    Integer projId;

    String projName;
    // 项目阶段
    String state;

    Integer ownerId;
    // 设计单位
    String designInstitute;

    Date date;

    Integer locationId;

}
