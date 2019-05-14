package com.sun.dailyprj.androidx.room.dao;

import com.sun.dailyprj.androidx.room.entity.User;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/*
 * =====================================================================================
 * Summary:
 *
 * File: UserDao.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/14 14:23
 * =====================================================================================
 */

/**
 * Dao(数据库操作类)
 *      @Dao                        ：  标注数据库操作的类。
 *
 *      @Query                     ：  包含所有Sqlite语句操作。
 *
 *      @Insert                      ：  标注数据库的插入操作。
 *
 *      @Delete                     ：  标注数据库的删除操作。
 *
 *      @Update                    ：  标注数据库的更新操作。
 *
 * 作者：Linhaojian
 * 链接：https://www.jianshu.com/p/ed69cc82f03f
 * 来源：简书
 */

@Dao
public interface UserDao{
    @Query("Select * from _user")
    List<User> getAllUser();

    @Query("Select * from _user where uid in(:userIds) ")
    List<User> loadAllByUserIds(int[] userIds);

    @Insert
    void insertAllUser(User... users);

    @Delete
    void delete(User... users);

    @Update
    void update(User... users);
@Query("update _user set name=:name1 where uid=:uid")
    void updateCustom(String name1,int uid);


}
