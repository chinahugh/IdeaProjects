package com.datasource.entity;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

public class Testdatasource implements Serializable {
    private static final long serialVersionUID = -7589767149137775447L;
    Integer id;
    @NotBlank(message = "name不能为空")
    String name;
    LocalDateTime insertime;

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

    public LocalDateTime getInsertime() {
        return insertime;
    }

    public void setInsertime(LocalDateTime insertime) {
        this.insertime = insertime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", insertime=" + insertime +
                '}';
    }
}
