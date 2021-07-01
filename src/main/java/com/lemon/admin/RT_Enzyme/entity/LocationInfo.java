package com.lemon.admin.RT_Enzyme.entity;

import lombok.Data;

@Data
public class LocationInfo {

    Integer locationId;

    String location;
    // 安装容量
    Float capacity;
    // 用地面积
    Float area;
    // 海拔高度
    Float altitude;
    // 经度
    Float latitude;
    //唯独
    Float longitude;
    // 水平太阳总辐射1
    Float radiation;
    // 水平太阳总辐射2
    Float radiation2;
    // 最佳辐射量倾角
    Float bestAngle;

    Integer metId;
}
