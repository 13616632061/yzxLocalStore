package com.yzx.yzxlocalstore.ui.Adapter;

import android.content.Context;
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

    private Context mContext;
    public WeightBarFragmentTypeAdapter(Context mContext,int layoutResId, @Nullable List<GoodsType> data) {
        super(layoutResId, data);
        this.mContext=mContext;
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsType item) {
        if (item.getIsSelect()){
            helper.setBackgroundRes(R.id.tv_name,R.drawable.bg_select_gray);
            helper.setTextColor(R.id.tv_name,mContext.getResources().getColor(R.color.color_f5260b));
        }else {
            helper.setBackgroundRes(R.id.tv_name,R.drawable.bg_select_whilte);
            helper.setTextColor(R.id.tv_name,mContext.getResources().getColor(R.color.color_000000));
        }
        helper.setText(R.id.tv_name, item.getTypeName());
    }
}
