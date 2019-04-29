package com.sun.dailyprj.lazyfragment;


import java.util.List;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/*
 * =====================================================================================
 * Summary:
 *
 * File: LazyFragmentPageAdapter.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/29 11:14
 * =====================================================================================
 */
public class LazyFragmentPageAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;

    public LazyFragmentPageAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
