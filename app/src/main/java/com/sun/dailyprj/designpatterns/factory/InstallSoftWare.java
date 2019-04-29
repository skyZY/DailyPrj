package com.sun.dailyprj.designpatterns.factory;

import java.util.LinkedList;

import javax.crypto.Mac;

/*
 * =====================================================================================
 * Summary:
 *
 * File: InstallSoftWare.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/3 14:15
 * =====================================================================================
 */
public abstract class InstallSoftWare{

    /**
     * 安装系统
     *
     * @param systemOs 系统
     */
    public abstract void installSystem(String systemOs);

    /**
     * 安装网卡驱动
     *
     * @param netCardType 网卡型号
     */
    public abstract void installNetCardDriver(String netCardType);

    public <T,E> LinkedList<String> installInputMethod(T t, E e){
        if(e instanceof ComputerFactory) {
            if(t instanceof WindowsSoftware) {
                return ((ComputerFactory) e).getListData((WindowsSoftware)t);

            }else if(t instanceof MacSoftware){
                return ((ComputerFactory) e).getListData((MacSoftware)t);
            }else if(t instanceof UbuntuSoftware){
                return ((ComputerFactory) e).getListData((UbuntuSoftware)t);
            }
        }
        return null;
    }

}
