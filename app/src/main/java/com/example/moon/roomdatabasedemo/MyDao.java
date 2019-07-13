package com.example.moon.roomdatabasedemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public abstract void addUser(User user);

    @Delete
    public abstract void removeUser(User user);

    @Query("select * from user")
    public abstract List<User> getUsers();
}
