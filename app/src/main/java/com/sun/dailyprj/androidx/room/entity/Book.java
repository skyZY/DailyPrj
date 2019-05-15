package com.sun.dailyprj.androidx.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/*
 * =====================================================================================
 * Summary:
 *
 * File: Book.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/14 14:18
 * =====================================================================================
 */
@Entity(tableName = "_book",
        foreignKeys = {
        @ForeignKey(entity = User.class,
                parentColumns = "uid",
                childColumns = "bookId")
})
public class Book{
    @PrimaryKey(autoGenerate = true)
    public int bookId;
    public String title;
    @ColumnInfo(name = "user_id")
    public int userId;

}
