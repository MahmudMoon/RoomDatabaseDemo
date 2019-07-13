package com.example.moon.roomdatabasedemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    private int uid;

    @ColumnInfo(name = "user_name")
    private String name;

    @ColumnInfo(name = "user_email")
    private String email;

    public User() {
    }

    public User(int uid, String name, String email) {
        this.uid = uid;
        this.name = name;
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
