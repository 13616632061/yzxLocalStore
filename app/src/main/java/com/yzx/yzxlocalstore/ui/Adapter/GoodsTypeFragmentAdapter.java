package com.yzx.yzxlocalstore.ui.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypeFragmentAdapter extends BaseQuickAdapter<GoodsType, BaseViewHolder> {

    public GoodsTypeFragmentAdapter(int layoutResId, @Nullable List<GoodsType> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsType item) {

    }
}
