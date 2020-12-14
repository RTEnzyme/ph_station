package com.lemon.admin.cofjus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Brand {
    @Id
    private Integer id;

    //品牌名称
    private String name;

    //代理商人数
    private Integer trader_count;

    //代理商开直播人数
    private Integer live_trader_count;

    //更新日期
    private Date update_time;

    //用户名
    private String username;

    //密码
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTrader_count() {
        return trader_count;
    }

    public void setTrader_count(Integer trader_count) {
        this.trader_count = trader_count;
    }

    public Integer getLive_trader_count() {
        return live_trader_count;
    }

    public void setLive_trader_count(Integer live_trader_count) {
        this.live_trader_count = live_trader_count;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user_name) {
        this.username = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
