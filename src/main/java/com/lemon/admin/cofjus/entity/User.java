package com.lemon.admin.cofjus.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.Date;

@Entity
public class User {
    private int id;
    private String uid;
    private String kolName;
    private String uniqueId;
    private String isSettled;
    private Integer fansCount;
    private String price;
    private Integer expectedPlayNum;
    private String avatarUrl;
    private String starLabel;
    private String selectLabel1;
    private String selectLabel2;
    private String selectLabel3;
    private String beforePrice;
    private String cooperateDegree;
    private Integer lastLabelId;
    private Date lastLabelTime;
    private Integer preLabelId;
    private Date preLabelTime;
    private String beforePrice2;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid", nullable = false, length = 64)
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "kol_name", nullable = true, length = 64)
    public String getKolName() {
        return kolName;
    }

    public void setKolName(String kolName) {
        this.kolName = kolName;
    }

    @Basic
    @Column(name = "unique_id", nullable = true, length = 128)
    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Basic
    @Column(name = "is_settled", nullable = true, length = 8)
    public String getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(String isSettled) {
        this.isSettled = isSettled;
    }

    @Basic
    @Column(name = "fans_count", nullable = true)
    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 64)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "expected_play_num", nullable = true)
    public Integer getExpectedPlayNum() {
        return expectedPlayNum;
    }

    public void setExpectedPlayNum(Integer expectedPlayNum) {
        this.expectedPlayNum = expectedPlayNum;
    }

    @Basic
    @Column(name = "avatar_url", nullable = true, length = -1)
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Basic
    @Column(name = "star_label", nullable = true, length = 32)
    public String getStarLabel() {
        return starLabel;
    }

    public void setStarLabel(String starLabel) {
        this.starLabel = starLabel;
    }

    @Basic
    @Column(name = "select_label1", nullable = true, length = 32)
    public String getSelectLabel1() {
        return selectLabel1;
    }

    public void setSelectLabel1(String selectLabel1) {
        this.selectLabel1 = selectLabel1;
    }

    @Basic
    @Column(name = "select_label2", nullable = true, length = 32)
    public String getSelectLabel2() {
        return selectLabel2;
    }

    public void setSelectLabel2(String selectLabel2) {
        this.selectLabel2 = selectLabel2;
    }

    @Basic
    @Column(name = "select_label3", nullable = true, length = 32)
    public String getSelectLabel3() {
        return selectLabel3;
    }

    public void setSelectLabel3(String selectLabel3) {
        this.selectLabel3 = selectLabel3;
    }

    @Basic
    @Column(name = "before_price", nullable = true, length = 10)
    public String getBeforePrice() {
        return beforePrice;
    }

    public void setBeforePrice(String beforePrice) {
        this.beforePrice = beforePrice;
    }

    @Basic
    @Column(name = "cooperate_degree", nullable = true, length = 8)
    public String getCooperateDegree() {
        return cooperateDegree;
    }

    public void setCooperateDegree(String cooperateDegree) {
        this.cooperateDegree = cooperateDegree;
    }

    @Basic
    @Column(name = "last_label_id", nullable = true)
    public Integer getLastLabelId() {
        return lastLabelId;
    }

    public void setLastLabelId(Integer lastLabelId) {
        this.lastLabelId = lastLabelId;
    }

    @Basic
    @Column(name = "last_label_time", nullable = true)
    public Date getLastLabelTime() {
        return lastLabelTime;
    }

    public void setLastLabelTime(Date lastLabelTime) {
        this.lastLabelTime = lastLabelTime;
    }

    @Basic
    @Column(name = "pre_label_id", nullable = true)
    public Integer getPreLabelId() {
        return preLabelId;
    }

    public void setPreLabelId(Integer preLabelId) {
        this.preLabelId = preLabelId;
    }

    @Basic
    @Column(name = "pre_label_time", nullable = true)
    public Date getPreLabelTime() {
        return preLabelTime;
    }

    public void setPreLabelTime(Date preLabelTime) {
        this.preLabelTime = preLabelTime;
    }

    @Basic
    @Column(name = "before_price_2", nullable = true, length = 10)
    public String getBeforePrice2() {
        return beforePrice2;
    }

    public void setBeforePrice2(String beforePrice2) {
        this.beforePrice2 = beforePrice2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(uid, user.uid) &&
                Objects.equals(kolName, user.kolName) &&
                Objects.equals(uniqueId, user.uniqueId) &&
                Objects.equals(isSettled, user.isSettled) &&
                Objects.equals(fansCount, user.fansCount) &&
                Objects.equals(price, user.price) &&
                Objects.equals(expectedPlayNum, user.expectedPlayNum) &&
                Objects.equals(avatarUrl, user.avatarUrl) &&
                Objects.equals(starLabel, user.starLabel) &&
                Objects.equals(selectLabel1, user.selectLabel1) &&
                Objects.equals(selectLabel2, user.selectLabel2) &&
                Objects.equals(selectLabel3, user.selectLabel3) &&
                Objects.equals(beforePrice, user.beforePrice) &&
                Objects.equals(cooperateDegree, user.cooperateDegree) &&
                Objects.equals(lastLabelId, user.lastLabelId) &&
                Objects.equals(lastLabelTime, user.lastLabelTime) &&
                Objects.equals(preLabelId, user.preLabelId) &&
                Objects.equals(preLabelTime, user.preLabelTime) &&
                Objects.equals(beforePrice2, user.beforePrice2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, kolName, uniqueId, isSettled, fansCount, price, expectedPlayNum, avatarUrl, starLabel, selectLabel1, selectLabel2, selectLabel3, beforePrice, cooperateDegree, lastLabelId, lastLabelTime, preLabelId, preLabelTime, beforePrice2);
    }
}
