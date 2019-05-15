package com.sun.dailyprj.androidx.viewmodel.bean;

/*
 * =====================================================================================
 * Summary:
 *
 * File: Person.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/15 10:36
 * =====================================================================================
 */
public class Person{

    public String name;

    public int age;

    public String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
