package com.sun.dailyprj.androidx.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/*
 * =====================================================================================
 * Summary:
 *
 * File: Address.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/14 14:14
 * =====================================================================================
 */
@Entity(tableName = "_address")
public class Address{
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "street")
    private String street;
    @ColumnInfo(name = "state")
    private String state;
    @ColumnInfo(name = "city")
    private String city;
    @ColumnInfo(name = "post_code")
    private int postCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }
}
