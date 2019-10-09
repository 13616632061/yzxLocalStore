package com.yzx.yzxlocalstore.ui.Adapter;

import android.support.annotation.Nullable;
import android.support.annotation.PluralsRes;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class ShortcutBarFragmentAdapter extends BaseQuickAdapter<GoodsInfo, BaseViewHolder> {

    private int layoutWidth;
    private int spantNum;

    public ShortcutBarFragmentAdapter(int layoutResId, @Nullable List<GoodsInfo> data, int layoutWidth,int spantNum) {
        super(layoutResId, data);
        this.layoutWidth = layoutWidth;
        this.spantNum = spantNum;
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsInfo item) {
        RelativeLayout layoutItem = helper.getView(R.id.layout_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width = (layoutWidth-10*(spantNum+1)) / spantNum;
        layoutParams.height = layoutParams.width;
        layoutItem.setLayoutParams(layoutParams);

        helper.setText(R.id.tv_name, item.getGoodName());
        helper.setText(R.id.tv_price, ArithUtil.roundByScale(item.getGoodPrice() + "", "#0.00"));
    }
}
