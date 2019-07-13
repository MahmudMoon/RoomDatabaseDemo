package com.example.moon.roomdatabasedemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public abstract void addUser(User user);

    @Query("delete from user where uid = :myuid")
    public abstract void removeUser(int myuid);

    @Query("select * from user")
    public abstract List<User> getUsers();

    @Update
    public abstract void updateUser(User user);

}
