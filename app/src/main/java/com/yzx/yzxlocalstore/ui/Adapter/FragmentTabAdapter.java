package com.yzx.yzxlocalstore.ui.Adapter;

import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.Constants;

import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

/**
 * Created by Administrator on 2019/5/10.
 * 垂直分类
 */

public class FragmentTabAdapter implements TabAdapter {

    private String[] data;

    public FragmentTabAdapter(String[] data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public ITabView.TabBadge getBadge(int position) {
        return null;
    }

    @Override
    public ITabView.TabIcon getIcon(int position) {
        return null;
    }

    @Override
    public ITabView.TabTitle getTitle(int position) {
        return new QTabView.TabTitle.Builder().setContent(data[position])
                .setTextColor(R.color.color_f5260b,R.color.color_707070)
                .setTextSize(15)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return R.color.whilte;
    }
}
