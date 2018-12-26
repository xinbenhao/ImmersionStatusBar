package com.xinda.immersionstatusbar;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //下拉刷新
    private SwipeRefreshLayout FirstSwipeRefreshLayout;
    private RecyclerView FirstRecyclerView;
    private Toolbar FirstToolBar;
    private String SwipeRefreshColor="#1E90FF";
    //设置加载数据
    private List<AddX>list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coor);
            //加载数据
        final AddX addX=new AddX();
         final Random random=new Random();

        addX.setUsername("安泽宇"+random.nextInt(100));
        list.add(addX);

        //设置下拉刷新
        FirstSwipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.FirstSwipeRefreshLayout);
        FirstRecyclerView=(RecyclerView)findViewById(R.id.FirstRecyclerView);
        FirstRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        final Adapter adapter=new Adapter(R.layout.adapter,list);
        FirstRecyclerView.setAdapter(adapter);
        FirstToolBar=(Toolbar)findViewById(R.id.FirstToolBar);

        //设置颜色
        FirstSwipeRefreshLayout.setColorSchemeColors(Color.parseColor(SwipeRefreshColor));

              //设置位置
            //true代表下拉球会由小变大
          //start表示高度上的起始位置，end表示在高度上的结束位置
        FirstSwipeRefreshLayout.setProgressViewOffset(true,120,300);
        //设置下拉进度背景颜色
        //FirstSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.parseColor(SwipeRefreshColor));

        //设置下拉监听
        FirstSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                FirstSwipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                                   //加载数据
                                adapter.addData(addX);
                                adapter.notifyDataSetChanged();
                                  //关闭下拉刷新
                        FirstSwipeRefreshLayout.setRefreshing(false);

                    }
                },600);

            }
        });


    }

}
