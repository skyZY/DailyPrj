package com.sun.dailyprj.androidx.viewmodel;

import com.sun.dailyprj.androidx.viewmodel.bean.Person;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/*
 * =====================================================================================
 * Summary:
 *
 * File: PersonViewModel.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/15 10:37
 * =====================================================================================
 */
public class PersonViewModel extends ViewModel{

    public Person person = new Person();//业务内需要使用的对象

    public MutableLiveData<Person> personLiveData = new MutableLiveData<>();
}
