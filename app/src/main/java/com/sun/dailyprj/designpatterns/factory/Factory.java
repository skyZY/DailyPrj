package com.sun.dailyprj.designpatterns.factory;

import java.util.LinkedList;

/*
 * =====================================================================================
 * Summary:
 *
 * File: Factory.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/3 14:21
 * =====================================================================================
 */
public abstract class Factory{
    public abstract <T extends InstallSoftWare> T getComputer(Class<T> clz);

    public abstract <T extends InstallSoftWare> LinkedList<String> getListData(T t);
}
