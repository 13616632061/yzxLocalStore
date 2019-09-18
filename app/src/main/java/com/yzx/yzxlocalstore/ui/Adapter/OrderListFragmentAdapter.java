package com.yzx.yzxlocalstore.ui.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.OrderInfo;

import java.util.List;

/**
 * Created by Administrator on 2019/9/18.
 */

public class OrderListFragmentAdapter extends BaseQuickAdapter<OrderInfo, BaseViewHolder> {

    private Context mContext;

    public OrderListFragmentAdapter(Context mContext, int layoutResId, @Nullable List<OrderInfo> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderInfo item) {
        //设置item单双行背景
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setBackgroundColor(R.id.layout_item, mContext.getResources().getColor(R.color.whilte));
        } else {
            helper.setBackgroundColor(R.id.layout_item, mContext.getResources().getColor(R.color.color_f1f1f1));
        }
        //订单选中状态
        if (item.getIsSelect()) {
            helper.setImageResource(R.id.iv_select, R.drawable.select);
        } else {
            helper.setImageResource(R.id.iv_select, R.drawable.unselect);
        }
        //订单号
        helper.setText(R.id.tv_order_num, item.getOrderId());
        //下单时间
        helper.setText(R.id.tv_create_time, item.getOrderCreatTime());
        //订单状态
        switch (item.getOrderStatus()) {
            case 0://未完成
                helper.setText(R.id.tv_order_status, mContext.getResources().getString(R.string.no_completed));
                break;
            case 1://已完成
                helper.setText(R.id.tv_order_status, mContext.getResources().getString(R.string.completed));
                break;
        }
        //付款状态
        switch (item.getOrderPaySatus()) {
            case 0://未支付
                helper.setText(R.id.tv_pay_status, mContext.getResources().getString(R.string.no_pay));
                break;
            case 1://已支付
                helper.setText(R.id.tv_pay_status, mContext.getResources().getString(R.string.payed));
                break;
        }
        //支付方式
        switch (item.getOrderPayType()) {
            case 0://未支付
                helper.setText(R.id.tv_pay_type, mContext.getResources().getString(R.string.nothing));
                break;
            case 1://现金支付
                helper.setText(R.id.tv_pay_type, mContext.getResources().getString(R.string.cash_pay));
                break;
            case 2://微信支付
                helper.setText(R.id.tv_pay_type, mContext.getResources().getString(R.string.wx_pay));
                break;
            case 3://支付宝支付
                helper.setText(R.id.tv_pay_type, mContext.getResources().getString(R.string.zfb_pay));
                break;
            case 4://会员支付
                helper.setText(R.id.tv_pay_type, mContext.getResources().getString(R.string.membership_payment));
                break;
        }
        //订单金额
        helper.setText(R.id.tv_order_money, ArithUtil.roundByScale(item.getTotalMoney() + "", "#0.00"));
        //利润
        helper.setText(R.id.tv_order_profit, ArithUtil.roundByScale((item.getOrderProfit() * 100) + "", "0.00") + "%");
        //订单类型
        switch (item.getOrderType()) {
            case 0://正常订单
                helper.setText(R.id.tv_order_type, mContext.getResources().getString(R.string.nomal_order));
                break;
            case 1://挂单
                helper.setText(R.id.tv_order_type, mContext.getResources().getString(R.string.put_order));
                break;
            case 2://作废订单
                helper.setText(R.id.tv_order_type, mContext.getResources().getString(R.string.order_invalid));
                break;
        }
        //下单人
        helper.setText(R.id.tv_create_person, item.getOrderCreatPerson().getName());

        helper.addOnClickListener(R.id.tv_handle);
        helper.addOnClickListener(R.id.iv_select);


    }
}
