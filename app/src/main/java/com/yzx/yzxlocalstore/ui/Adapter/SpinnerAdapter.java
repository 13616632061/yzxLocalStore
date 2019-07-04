package com.yzx.yzxlocalstore.ui.Adapter;

import android.content.Context;

import com.yzx.lib.weight.OneLayoutBaseAdapter;
import com.yzx.yzxlocalstore.R;

/**
 * Created by Administrator on 2019/7/4.
 */

public class SpinnerAdapter extends OneLayoutBaseAdapter<String> {

    public SpinnerAdapter(Context context, int resid) {
        super(context, resid);
    }

    @Override
    public void bindView(ViewHolder viewHolder, String datas) {
        viewHolder.bindTextView(R.id.tv_score, datas);
    }
}
