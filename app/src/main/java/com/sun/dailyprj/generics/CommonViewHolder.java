package com.sun.dailyprj.generics;

import android.util.SparseArray;
import android.view.View;

/*
 * =====================================================================================
 * Summary:
 *
 * File: CommonViewHolder.java
 * Author: Yanpeng.Sun
 * Create: 2019/4/26 16:47
 * =====================================================================================
 */
public class CommonViewHolder{

    /**
     * @param view 所有缓存View的根View
     * @param id   缓存View的唯一标识
     * @return
     */
    public static <T extends View> T get(View view,int id){
        SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();
        //如果跟view没有用来缓存View的集合
        if(viewHolder == null){
            viewHolder = new SparseArray<>();
            view.setTag(viewHolder);//创建集合和根view关联
        }
        View childView = viewHolder.get(id);//获取根View储存在集合中的view child
        if(childView == null){
            //找到该view child
            childView = view.findViewById(id);
            viewHolder.put(id,childView);
        }
        return (T)childView;
    }
}
