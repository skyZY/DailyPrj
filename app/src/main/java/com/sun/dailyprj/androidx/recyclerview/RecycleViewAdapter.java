package com.sun.dailyprj.androidx.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sun.dailyprj.R;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/*
 * =====================================================================================
 * Summary:
 *
 * File: RecycleViewAdapter.java
 * Author: Yanpeng.Sun
 * Create: 2019/5/9 17:35
 * =====================================================================================
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecyclerViewHolder>{

    private List<String> mDatas;

    public RecycleViewAdapter(ArrayList<String> datas) {
        this.mDatas = datas;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.textView.setText(mDatas.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //item 点击事件
                Log.i("syp", "click position:" + position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public final TextView textView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview_rv);
        }
    }
}
