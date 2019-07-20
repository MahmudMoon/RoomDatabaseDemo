package com.example.moon.roomdatabasedemo.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moon.roomdatabasedemo.entitys.User;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
     void addUser(User user);

    @Query("delete from user where uid = :myuid")
     void removeUser(int myuid);

    @Query("select * from user")
    List<User> getUsers();

    @Update
     void updateUser(User user);

}
