package com.sun.dailyprj.lazyfragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sun.common.lazy.fragment.LazyFragment;
import com.sun.dailyprj.R;

public class MoreFragment extends LazyFragment{
    private TextView tvLoading;
    private int tabIndex;
    public static final String INTENT_INT_INDEX="index";

    public static MoreFragment newInstance(int tabIndex,boolean isLazyLoad) {

        Bundle args = new Bundle();
        args.putInt(INTENT_INT_INDEX, tabIndex);
        args.putBoolean(LazyFragment.INTENT_BOOLEAN_LAZYLOAD, isLazyLoad);
        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_tabitem);
		tabIndex = getArguments().getInt(INTENT_INT_INDEX);
        tvLoading = (TextView) findViewById(R.id.txt_lazy_fragment);

        getData();
    }

    private void getData() {

        new Thread(new Runnable(){
            @Override
            public void run() {
                //异步处理加载数据
                //...
                //完成后，通知主线程更新UI
                handler.sendEmptyMessageDelayed(tabIndex, 2000);
            }
        }).start();
    }

    @Override
    public void onDestroyViewLazy() {
        super.onDestroyViewLazy();
        handler.removeMessages(tabIndex);
    }

    private Handler handler = new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(Message msg) {
            String content = "";
            switch(tabIndex){
                case 1:
                    content = "Scenic";
                    break;
                case 2:
                    content = "ScenicSport";
                    break;
                case 3:
                    content = "Post";
                    break;
                case 4:
                    content = "DataBindingUser";
                    break;
            }
            tvLoading.setText(content);
            return false;
        }
    });
}