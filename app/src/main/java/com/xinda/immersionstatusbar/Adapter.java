package com.xinda.immersionstatusbar;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by lenovo on 2018/8/21.
 */

public class Adapter extends BaseQuickAdapter<AddX,BaseViewHolder>{
    public Adapter(@LayoutRes int layoutResId, @Nullable List<AddX> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AddX item) {

        //设置ID 加载内容
        helper.setText(R.id.AdapterTextView,item.getUsername())
                .addOnClickListener(R.id.AdapterTextView);

    }
}
