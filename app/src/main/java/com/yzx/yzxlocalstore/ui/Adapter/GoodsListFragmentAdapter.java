package com.yzx.yzxlocalstore.ui.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/7/15.
 */

public class GoodsListFragmentAdapter extends BaseQuickAdapter<GoodsInfo, BaseViewHolder> {


    private Context mContext;

    public GoodsListFragmentAdapter(Context mContext, int layoutResId, @Nullable List<GoodsInfo> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsInfo item) {
        //商品选中状态
        if (item.getIsSelect()) {
            helper.setImageResource(R.id.iv_select, R.drawable.select);
        } else {
            helper.setImageResource(R.id.iv_select, R.drawable.unselect);
        }
        //商品名字
        helper.setText(R.id.tv_good_name, item.getGoodName());
        //商品销售价
        helper.setText(R.id.tv_good_price, ArithUtil.roundByScale(item.getGoodPrice() + "", "#0.00"));
        //商品库存
        helper.setText(R.id.tv_good_store, item.getGoodStore() + "");
        //商品利润
        helper.setText(R.id.tv_goods_profit, ArithUtil.roundByScale((item.getGoodProfit() * 100) + "", "0.00") + "%");
        //商品分类名字
        if (item.getGoodsType() != null) {
            helper.setText(R.id.tv_goods_type, item.getGoodsType().getTypeName() + "");
        } else {
            helper.setText(R.id.tv_goods_type, mContext.getResources().getString(R.string.defaut_type));
        }
        //商品状态
        if (item.getGoodStatus()) {
            helper.setText(R.id.tv_goods_status, mContext.getResources().getString(R.string.up_shelf));
        } else {
            helper.setText(R.id.tv_goods_status, mContext.getResources().getString(R.string.down_shelf));
        }
        //背景
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setBackgroundRes(R.id.layout_item, R.color.white);
        } else {
            helper.setBackgroundRes(R.id.layout_item, R.color.color_F8F8FF);
        }

        helper.addOnClickListener(R.id.tv_edit);
        helper.addOnClickListener(R.id.iv_select);

    }
}
