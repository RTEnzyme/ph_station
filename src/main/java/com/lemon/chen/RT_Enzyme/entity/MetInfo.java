package com.lemon.chen.RT_Enzyme.entity;

import lombok.Data;

@Data
public class MetInfo {

    Integer metId;
    // 多年平均气温
    Float avgTemp;
    // 多年极端最高气温
    Float maxTemp;
    // 多年极端最低气温
    Float minTemp;
    // 最热每月平均气温
    Float maxMonTemp;
    // 多年最大冻土深度
    Float maxDepth;
    // 多年平均风速
    Float avgSpeed;
    // 多年极大风速
    Float maxSpeed;
    // 多年平均雷暴日数
    Integer stormDays;
    // 污秽等级
    String pollution;

}
