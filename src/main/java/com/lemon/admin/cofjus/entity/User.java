package com.lemon.admin.cofjus.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "kol_data")
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
    private String beforePrice;
    private Integer cooperateDegree;
    private Timestamp lastLabelTime;
    private Timestamp preLabelTime;

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
    @Column(name = "before_price", nullable = true, length = 10)
    public String getBeforePrice() {
        return beforePrice;
    }

    public void setBeforePrice(String beforePrice) {
        this.beforePrice = beforePrice;
    }

    @Basic
    @Column(name = "cooperate_degree", nullable = true)
    public Integer getCooperateDegree() {
        return cooperateDegree;
    }

    public void setCooperateDegree(Integer cooperateDegree) {
        this.cooperateDegree = cooperateDegree;
    }

    @Basic
    @Column(name = "last_label_time", nullable = true)
    public Timestamp getLastLabelTime() {
        return lastLabelTime;
    }

    public void setLastLabelTime(Timestamp lastLabelTime) {
        this.lastLabelTime = lastLabelTime;
    }

    @Basic
    @Column(name = "pre_label_time", nullable = true)
    public Timestamp getPreLabelTime() {
        return preLabelTime;
    }

    public void setPreLabelTime(Timestamp preLabelTime) {
        this.preLabelTime = preLabelTime;
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
                Objects.equals(beforePrice, user.beforePrice) &&
                Objects.equals(cooperateDegree, user.cooperateDegree) &&
                Objects.equals(lastLabelTime, user.lastLabelTime) &&
                Objects.equals(preLabelTime, user.preLabelTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, kolName, uniqueId, isSettled, fansCount, price, expectedPlayNum, avatarUrl, starLabel, beforePrice, cooperateDegree, lastLabelTime, preLabelTime);
    }
}
