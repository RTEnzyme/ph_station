package com.lemon.chen.RT_Enzyme.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "operator", schema = "kol_data")
public class Operator {
    private Integer id;
    private String userName;
    private String password;
    private Integer labeledCount;
    private Integer updateCount;
    private Integer page;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 32)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "labeled_count", nullable = true)
    public Integer getLabeledCount() {
        return labeledCount;
    }

    public void setLabeledCount(Integer labeledCount) {
        this.labeledCount = labeledCount;
    }

    @Basic
    @Column(name = "update_count", nullable = true)
    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    @Basic
    @Column(name= "page",nullable = true)
    public Integer getPage(){ return page;}

    public void setPage(Integer page){ this.page = page;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operator operator = (Operator) o;
        return id == operator.id &&
                Objects.equals(userName, operator.userName) &&
                Objects.equals(password, operator.password) &&
                Objects.equals(labeledCount, operator.labeledCount) &&
                Objects.equals(updateCount, operator.updateCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, labeledCount, updateCount);
    }
}
