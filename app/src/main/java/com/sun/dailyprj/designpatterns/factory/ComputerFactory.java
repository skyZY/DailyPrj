package com.sun.dailyprj.designpatterns.factory;

import java.util.LinkedList;

/*
 * =====================================================================================
 * Summary:
 *
 * File: ComputerFactory.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/3 14:23
 * =====================================================================================
 */
public class ComputerFactory extends Factory{
    @Override
    public <T extends InstallSoftWare> T getComputer(Class<T> clz) {
        InstallSoftWare installSoftWare = null;
        try{
            installSoftWare = (InstallSoftWare) Class.forName(clz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) installSoftWare;
    }

    @Override
    public <T extends InstallSoftWare> LinkedList<String> getListData(T t) {
        if(t instanceof WindowsSoftware)
            return mCanList;
        else if(t instanceof MacSoftware)
            return mDevList;
        else if(t instanceof UbuntuSoftware)
            return mMasterList;
        return null;
    }


    private LinkedList<String> mCanList = new LinkedList<>();
    private LinkedList<String> mDevList = new LinkedList<>();
    private LinkedList<String> mMasterList = new LinkedList<>();
    public ComputerFactory(){
        //实现各个list数据填充
        mCanList.add("MCU");
        mCanList.add("VCU");

        mDevList.add("IVI");
        mDevList.add("GW");
        mDevList.add("APP_MODEM");

        mMasterList.add("tbox");
        mMasterList.add("master");
        System.out.println("ComputerFactory() contrust");
    }



}
