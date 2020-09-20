package com.datasource.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class User {
    Integer id;
    String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
