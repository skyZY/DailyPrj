package com.sun.dailyprj.androidx.room;

import android.content.Context;

import com.sun.dailyprj.androidx.room.dao.UserDao;
import com.sun.dailyprj.androidx.room.entity.Book;
import com.sun.dailyprj.androidx.room.entity.User;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/*
 * =====================================================================================
 * Summary:
 *
 * File: RoomAppDatabase.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/14 14:38
 * =====================================================================================
 */

/**
 * Database(数据库持久化)
 *
 * @Database ： 标注数据库持久化的类。
 */
@Database(entities = {User.class, Book.class}, version = 1)
public abstract class RoomAppDatabase extends RoomDatabase{

    private static final String DB_NAME = "room_db";

    public abstract UserDao getUserDao();

    private static RoomAppDatabase sInstance;

    public static RoomAppDatabase getInstance(Context context) {
        if(sInstance == null) {
            synchronized(RoomAppDatabase.class) {
                if(sInstance == null) {
                    sInstance = Room.databaseBuilder(context, RoomAppDatabase.class, DB_NAME).build();
                }
            }
        }
        return sInstance;
    }

}
