package com.yzx.yzxlocalstore.ui.Adapter;

import android.content.Context;

import com.yzx.lib.weight.OneLayoutBaseAdapter;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsType;

/**
 * Created by Administrator on 2019/7/10.
 */

public class SpinnerGoodsTypeAdapter extends OneLayoutBaseAdapter<GoodsType> {

    public SpinnerGoodsTypeAdapter(Context context, int resid) {
        super(context, resid);
    }

    @Override
    public void bindView(ViewHolder viewHolder, GoodsType datas) {
        viewHolder.bindTextView(R.id.tv_score, datas.getTypeName());

    }
}
