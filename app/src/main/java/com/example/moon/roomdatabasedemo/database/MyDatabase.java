package com.example.moon.roomdatabasedemo.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.moon.roomdatabasedemo.entitys.User;
import com.example.moon.roomdatabasedemo.dao.MyDao;

@Database(entities = {User.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao getDao();
}
