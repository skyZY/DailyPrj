package com.sun.dailyprj.androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sun.dailyprj.R;
import com.sun.dailyprj.androidx.room.dao.UserDao;
import com.sun.dailyprj.androidx.room.entity.User;
import com.sun.dailyprj.databinding.ActivityRoomBinding;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

/*
 * =====================================================================================
 * Summary:
 *
 * File: RoomActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/14 13:50
 * =====================================================================================
 */

/**
 * 使用Room需要导Lib包
 * // room
 * implementation 'android.arch.persistence.room:runtime:1.1.1'
 * annotationProcessor 'android.arch.persistence.room:compiler:1.1.1'
 */

/**
 * 主要角色说明
 * <p>
 * Bean         ：  实体类，表示数据库表的数据。
 * Dao          ：  数据操作类，包含用于访问数据库的方法。
 * Database     ：  数据库持有者 & 数据库版本管理者。
 * Room         :    数据库的创建者 & 负责数据库版本更新的具体实现者。
 * 链接：https://www.jianshu.com/p/ed69cc82f03f
 * 来源：简书
 */

public class RoomActivity extends AppCompatActivity{
    private ActivityRoomBinding mBinding;
    private Context mContext;
    private ExecutorService mExecutors;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_room);
        mBinding.setRa(this);
        mContext = this;
        mExecutors = Executors.newFixedThreadPool(4);

        User user = new User();
        user.setName("zhang san");
        user.setRemark("remark");
        mBinding.setSetUser(user);
        mBinding.btnRoomCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                mExecutors.execute(new Runnable(){
                    @Override
                    public void run() {
                        UserDao dao = RoomAppDatabase.getInstance(mContext).getUserDao();
                    }
                });
            }
        });
        mBinding.btnRoomInsert.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mExecutors.execute(new Runnable(){
                    @Override
                    public void run() {
                        UserDao dao = RoomAppDatabase.getInstance(mContext).getUserDao();
                        User zhangyu = new User();
                        zhangyu.setName("Zhang yu");
                        zhangyu.setRemark("We went to high school together");
                        dao.insertAllUser(zhangyu);
                    }
                });
            }
        });

    }

    public void onUpdate(View view) {
        mExecutors.execute(new Runnable(){
            @Override
            public void run() {
                User userUpdate = new User();
                userUpdate.setName("zhang san");
                userUpdate.setRemark("update remark by name='zhang san'");
                RoomAppDatabase.getInstance(mContext).getUserDao().update();
                RoomAppDatabase.getInstance(mContext).getUserDao().updateCustom("Zhou wen wang", 3);
                List<User> users = RoomAppDatabase.getInstance(mContext).getUserDao().getAllUser();
                Log.i("syp", "users:" + users.toString());
            }
        });
    }

}
