package com.yzx.yzxlocalstore.ui.Adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.lib.util.ArithUtil;
import com.yzx.lib.util.TimeUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/10/10.
 */

public class TakeOutOrderPopuWindowAdapter extends BaseQuickAdapter<OrderInfo, BaseViewHolder> {


    public TakeOutOrderPopuWindowAdapter(int layoutResId, @Nullable List<OrderInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderInfo item) {
        //设置item单双行背景
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setBackgroundColor(R.id.layout_item, mContext.getResources().getColor(R.color.whilte));
        } else {
            helper.setBackgroundColor(R.id.layout_item, mContext.getResources().getColor(R.color.color_f1f1f1));
        }

        //序号
        helper.setText(R.id.tv_num, helper.getAdapterPosition() + 1+"");
        //订单号
        helper.setText(R.id.tv_order_num, item.getOrderId());
        //下单时间
        helper.setText(R.id.tv_create_time, TimeUtil.millis2String(item.getOrderCreatTime()));
        //订单金额
        helper.setText(R.id.tv_order_money, ArithUtil.roundByScale(item.getTotalMoney() + "", "#0.00"));
        //下单人
        helper.setText(R.id.tv_create_person, item.getOrderCreatPerson().getName());
        //订单商品
        if (item.getGoodsInfos() != null && item.getGoodsInfos().size() > 0) {
            String goodName = "";
            for (GoodsInfo bean : item.getGoodsInfos()) {
                goodName += bean.getGoodName() + " ";
            }
            helper.setText(R.id.tv_order_good_name, goodName);
        }


    }
}
