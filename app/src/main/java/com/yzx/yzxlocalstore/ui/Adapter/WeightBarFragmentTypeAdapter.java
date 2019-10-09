package com.yzx.yzxlocalstore.ui.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class WeightBarFragmentTypeAdapter extends BaseQuickAdapter<GoodsType, BaseViewHolder> {


    public WeightBarFragmentTypeAdapter(int layoutResId, @Nullable List<GoodsType> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsType item) {
        helper.setText(R.id.tv_name, item.getTypeName());
    }
}
