package com.lemon.admin.cofjus.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "label", schema = "kol_data")
public class Label {
    private String type;
    private int id;

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label label = (Label) o;
        return id == label.id &&
                Objects.equals(type, label.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }
}
