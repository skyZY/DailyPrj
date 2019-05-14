package com.sun.dailyprj.androidx.room;

import android.content.Context;

import com.sun.dailyprj.androidx.room.dao.UserDao;
import com.sun.dailyprj.androidx.room.entity.Book;
import com.sun.dailyprj.androidx.room.entity.User;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
 * update db
 */
@Database(entities = {User.class, Book.class}, version = 2)
public abstract class RoomAppDatabase extends RoomDatabase{

    private static final String DB_NAME = "room_db";

    public abstract UserDao getUserDao();

    private static RoomAppDatabase sInstance;

    public static RoomAppDatabase getInstance(Context context) {
        if(sInstance == null) {
            synchronized(RoomAppDatabase.class) {
                if(sInstance == null) {
                    sInstance = Room.databaseBuilder(context, RoomAppDatabase.class, DB_NAME).addMigrations(Migradtion_1_2).build();
                }
            }
        }
        return sInstance;
    }

    /**
     * 更新数据库版本 ：
     *  在User对象中，添加多一个属性：sex，看看修改的步骤有哪些：
     * 1.User实体中添加sex属性和remark属性
     *
     * 2.修改DateBase的版本信息 1 -> 2
     *
     * 3.添加一个Migration & 实现版本更新的具体内容
     *
     * 4.在数据库初始化中添加Migration
     */
    public static Migration Migradtion_1_2 = new Migration(1,2){
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("alter table _user add column sex text");
            database.execSQL("alter table _user add column remark text");
        }
    };

}
