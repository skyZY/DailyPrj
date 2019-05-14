package com.sun.dailyprj.androidx.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/*
 * =====================================================================================
 * Summary:
 *
 * File: DataBindingUser.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/14 13:55
 * =====================================================================================
 */

/**
 * 注释说明
 * 1.Bean(实体)
 *
 * @Entity ：  数据表的实体类。
 * @PrimaryKey ：  每一个实体类都需要一个唯一的标识。
 * @ColumnInfo ：  数据表中字段名称。
 * @Ignore ：  标注不需要添加到数据表中的属性。
 * @Embedded ：  实体类中引用其他实体类。
 * @ForeignKey ：  外键约束。
 * 链接：https://www.jianshu.com/p/ed69cc82f03f
 * 来源：简书
 */
@Entity(tableName = "_user")
public class User{
    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo
    private String remark;
    @Embedded
    public Address address;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User() {
    }

    @Ignore
    public User(int uid, String name, String remark, Address address) {
        this.uid = uid;
        this.name = name;
        this.remark = remark;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", address=" + address +
                '}';
    }
}
