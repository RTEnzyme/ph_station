package com.lemon.admin.cofjus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Agent {
    @Id
    private Integer id;

    @Column(name="nick_name")
    private String nickName;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="avatar_url")
    private String avatar_url;

    @Column(name="salt")
    private String salt;

    @Column(name="province")
    private String province;

    @Column(name="city")
    private String city;

    @Column(name="region")
    private String region;

    @Column(name="brand")
    private String brand;

//    private Integer total_post_count;

//    private Integer total_video_digg_count;

//    private Integer total_live_comment_count;

//    private Integer total_video_comment_count;

    @Column(name="fans_count")
    private Integer fans_count;

    @Column(name="last_week_fans")
    private Integer last_week_fans;

    //    private Integer live_count;
    @Column(name="rid")
    private Integer rid;

    @Column(name="is_live")
    private Integer is_live;

    @Column(name="bid")
    private Integer bid;

    @Column(name="update_time")
    private Date update_time;

    @Column(name="email")
    private String email;

    private Date excel_upload_time;

    @Column(name="excel_send_time")
    private java.util.Date excel_send_time;

    @Column(name="visible")
    private Integer visible;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick_name() {
        return nickName;
    }

    public void setNick_name(String nick_name) {
        this.nickName = nick_name;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

//    public Integer getTotal_post_count() {
//        return total_post_count;
//    }
//
//    public void setTotal_post_count(Integer total_post_count) {
//        this.total_post_count = total_post_count;
//    }
//
//    public Integer getTotal_videos_digg_count() {
//        return total_video_digg_count;
//    }
//
//    public void setTotal_videos_digg_count(Integer total_videos_digg_count) {
//        this.total_video_digg_count = total_videos_digg_count;
//    }
//
//    public Integer getTotal_live_comment_count() {
//        return total_live_comment_count;
//    }
//
//    public void setTotal_live_comment_count(Integer total_live_comment_count) {
//        this.total_live_comment_count = total_live_comment_count;
//    }
//
//    public Integer getTotal_video_comment_count() {
//        return total_video_comment_count;
//    }
//
//    public void setTotal_video_comment_count(Integer total_video_comment_count) {
//        this.total_video_comment_count = total_video_comment_count;
//    }

    public Integer getFans_count() {
        return fans_count;
    }

    public void setFans_count(Integer fans_count) {
        this.fans_count = fans_count;
    }

//    public Integer getLive_count() {
//        return live_count;
//    }
//
//    public void setLive_count(Integer live_count) {
//        this.live_count = live_count;
//    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getIs_live() {
        return is_live;
    }

    public void setIs_live(Integer is_live) {
        this.is_live = is_live;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLast_week_fans() {
        return last_week_fans;
    }

    public void setLast_week_fans(Integer last_week_fans) {
        this.last_week_fans = last_week_fans;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getExcel_upload_time() {
        return excel_upload_time;
    }

    public void setExcel_upload_time(Date excel_upload_time) {
        this.excel_upload_time = excel_upload_time;
    }

    public java.util.Date getExcel_send_time() {
        return excel_send_time;
    }

    public void setExcel_send_time(java.util.Date excel_send_time) {
        this.excel_send_time = excel_send_time;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }
}