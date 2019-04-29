package com.sun.dailyprj.generics;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sun.dailyprj.Constant;
import com.sun.dailyprj.R;
import com.sun.dailyprj.WebViewActivity;

import java.util.LinkedList;

import androidx.appcompat.app.AppCompatActivity;

/*
 * =====================================================================================
 * Summary:
 *
 * File: GenericAdapterActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/26 17:07
 * =====================================================================================
 */
public class GenericAdapterActivity extends AppCompatActivity{

    private final static LinkedList<GenericBean> mDataList = new LinkedList<>();

    private ListView mListView;
    private MyGenericAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_adapter);
        mListView = findViewById(R.id.listview_generic);
        adapter = new MyGenericAdapter(this,mDataList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(listener);
    }

    static {
        mDataList.add(new GenericBean("Java泛型应用之打造Android万能ViewHolder-超简洁写法", "https://blog.csdn.net/linglongxin24/article/details/52808656"));
        mDataList.add(new GenericBean("Android、Java泛型扫盲", "https://juejin.im/post/5cbd5986f265da035e2124a2"));
        mDataList.add(new GenericBean("Java泛型应用之打造Android中ListView和GridView万能适配器【CommonAdapter】--超简洁写法", "https://blog.csdn.net/linglongxin24/article/details/52813227"));
        mDataList.add(new GenericBean("转向Kotlin——泛型", "https://juejin.im/post/5afd68cc518825428630b76e"));

    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //启动WebView Activity
            Intent intent = new Intent(GenericAdapterActivity.this, WebViewActivity.class);
            intent.putExtra(Constant.KEY_WEB_URL,mDataList.get(position).getUrl());
            startActivity(intent);
        }
    };


}
