package com.xinda.immersionstatusbar;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * Created by lenovo on 2018/8/15.
 */

//监听下拉刷新
public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout FIRST_SWIPEREFRESH;

    public RefreshHandler(SwipeRefreshLayout first_swiperefresh) {
        FIRST_SWIPEREFRESH = first_swiperefresh;
        //设置下拉监听事件
        FIRST_SWIPEREFRESH.setOnRefreshListener(this);
    }

   public void refresh()
   {
       //setRefreshing()自动下拉刷新
       FIRST_SWIPEREFRESH.setRefreshing(true);
       //进行网络请求
   }

    //设置首页数据
    public void firstPage()
    {

    }
     //刷新时的操作
    @Override
    public void onRefresh() {
      refresh();
    }
}
