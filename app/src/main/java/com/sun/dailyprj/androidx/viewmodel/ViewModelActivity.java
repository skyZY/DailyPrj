package com.sun.dailyprj.androidx.viewmodel;

import android.os.Bundle;
import android.view.View;
import com.sun.dailyprj.R;
import com.sun.dailyprj.androidx.viewmodel.bean.Person;
import com.sun.dailyprj.databinding.ActivityViewModelBinding;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/*
 * =====================================================================================
 * Summary:
 *
 * File: ViewModelActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/15 10:19
 * =====================================================================================
 */

public class ViewModelActivity extends AppCompatActivity{
    ActivityViewModelBinding mBinding;

    private final static String sMessage = "ViewModel的gradle依赖如下：" + "\n" +
            "dependencies {\n" +
            "    ...\n" +
            "    implementation 'android.arch.lifecycle:extensions:1.1.1'\n" +
            "}" + "\n\n" + "ViewModel的声明\n" +
            "千万不能持有Context的引用，否则会引起内存泄漏，如果实在需要Context，可以继承AndroidViewModel，通过getApplication()获取Application。";

    private int age = 22;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_model);
        mBinding.setVma(this);
        mBinding.tvVmInfo.setText(sMessage);
        myFunction();
    }

    private void myFunction() {
        PersonViewModel model = ViewModelProviders.of(ViewModelActivity.this).get(PersonViewModel.class);
        model.person.setName("zhang san");
        model.person.setAge(22);
        model.person.setSex("male");
        mBinding.tvVmPerson.setText(model.person.toString());
        model.personLiveData.observe(this, new Observer<Person>(){
            @Override
            public void onChanged(Person person) {
                mBinding.tvVmPerson.setText(model.person.toString());
            }
        });
    }

    public void changePerson(View view) {
        PersonViewModel model = ViewModelProviders.of(ViewModelActivity.this).get(PersonViewModel.class);
        age +=1;
        model.person.setAge(age);
        model.personLiveData.setValue(model.person);
    }

}


