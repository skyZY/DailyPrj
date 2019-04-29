package com.sun.dailyprj.lazyfragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sun.dailyprj.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

/*
 * =====================================================================================
 * Summary:
 *
 * File: LazyFragmentActivity.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/29 11:03
 * =====================================================================================
 */
public class LazyFragmentActivity extends AppCompatActivity{

    private ViewPager mViewPager;
    private BottomNavigationView navigation;
    private List<Fragment> fragmentList;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.tab_scenic:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.tab_scenicsport:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.tab_post:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.tab_user:
                    mViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazyfragment);
        initId();
        initData();
    }

    private void initData() {
        fragmentList = new ArrayList<>();
        fragmentList.add(MoreFragment.newInstance(1,true));
        fragmentList.add(MoreFragment.newInstance(2,true));
        fragmentList.add(MoreFragment.newInstance(3,true));
        fragmentList.add(MoreFragment.newInstance(4,true));
        FragmentManager fragmentManager = getSupportFragmentManager();
        LazyFragmentPageAdapter adapter = new LazyFragmentPageAdapter(fragmentManager,fragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(4);
    }

    private void initId() {
        mViewPager = findViewById(R.id.viewpage_lazy);
        mViewPager.setOnPageChangeListener(pageChangeListener);
        navigation = findViewById(R.id.navigation_lazy);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if(position == 0) {
                navigation.setSelectedItemId(R.id.tab_scenic);
            } else if(position == 1) {
                navigation.setSelectedItemId(R.id.tab_scenicsport);
            } else if(position == 2) {
                navigation.setSelectedItemId(R.id.tab_post);
            } else if(position == 3) {
                navigation.setSelectedItemId(R.id.tab_user);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}
