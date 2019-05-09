package com.sun.dailyprj.androidx.recyclerview;

import android.os.Bundle;

import com.sun.dailyprj.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


/*
 * =====================================================================================
 * Summary:
 *
 * File: RecyclerViewActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/9 17:16
 * =====================================================================================
 */
public class RecyclerViewActivity extends AppCompatActivity{

    private RecyclerView mRecyclerView;
    private RecyclerView mRecycleViewGrid;
    private RecyclerView mRecycleViewStagg;
    private static List<String> mDatas = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        initId();

    }

    private void initId() {
        mRecyclerView = findViewById(R.id.recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        mRecyclerView.setAdapter(new RecycleViewAdapter((ArrayList<String>) mDatas));

        mRecycleViewGrid = findViewById(R.id.recycleview_grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mRecycleViewGrid.setLayoutManager(gridLayoutManager);
        mRecycleViewGrid.setAdapter(new RecycleViewAdapter((ArrayList<String>) mDatas));

        mRecycleViewStagg = findViewById(R.id.recycleview_stagg);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
        mRecycleViewStagg.setLayoutManager(staggeredGridLayoutManager);
        mRecycleViewStagg.setAdapter(new RecycleViewAdapter((ArrayList<String>) mDatas));

    }

    static {
        mDatas.add("Zhao");
        mDatas.add("Qian");
        mDatas.add("Sun");
        mDatas.add("Li");
        mDatas.add("Zhou wu eat bread");
        mDatas.add("Wu");
        mDatas.add("Zheng");
        mDatas.add("Wan");

        mDatas.add("Zhang san love her");
        mDatas.add("Li si");
        mDatas.add("Wang er");
        mDatas.add("Ma zi");

    }
}
