package com.yzx.yzxlocalstore.ui.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.SaleGoodsInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/8/8.
 */

public class MainLeftSaleGoodsListAdapter extends BaseQuickAdapter<SaleGoodsInfo, BaseViewHolder> {

    private Context mContext;

    public MainLeftSaleGoodsListAdapter(Context mContext, int layoutResId, @Nullable List<SaleGoodsInfo> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder helper, SaleGoodsInfo item) {
        //设置item单双行背景
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setBackgroundColor(R.id.layout_item, mContext.getResources().getColor(R.color.whilte));
            helper.setBackgroundColor(R.id.et_num, mContext.getResources().getColor(R.color.color_f1f1f1));
        } else {
            helper.setBackgroundColor(R.id.layout_item, mContext.getResources().getColor(R.color.color_f1f1f1));
            helper.setBackgroundColor(R.id.et_num, mContext.getResources().getColor(R.color.whilte));
        }
        if (item.isSelectItem()){
            helper.setBackgroundColor(R.id.layout_item, mContext.getResources().getColor(R.color.color_FF4500));
        }
        //序号
        helper.setText(R.id.tv_serial_number, (helper.getAdapterPosition() + 1) + "");
        //名字
        helper.setText(R.id.tv_name, item.getGoodsInfo().getGoodName());
        //单价
        helper.setText(R.id.tv_price, ArithUtil.roundByScale(item.getGoodsInfo().getGoodPrice() + "", "#0.00"));
        //数量
        helper.setText(R.id.et_num, ArithUtil.roundByScale(item.getNum() + "", "#0.0"));
        //小计
        helper.setText(R.id.tv_subtotal, ArithUtil.roundByScale(item.getSubtotalPrice() + "", "#0.00"));

    }
}
