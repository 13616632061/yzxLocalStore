package com.yzx.yzxlocalstore.ui.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;

import java.util.List;

/**
 * Created by Administrator on 2019/7/26.
 */

public class MainBottomTypeAdapter extends BaseQuickAdapter<TypeBean, BaseViewHolder> {

    private Context mContext;

    public MainBottomTypeAdapter(Context mContext, int layoutResId, @Nullable List<TypeBean> data) {
        super(layoutResId, data);
        this.mContext = mContext;
    }

    @Override
    protected void convert(BaseViewHolder helper, TypeBean item) {

        helper.setText(R.id.tv_function_type, item.getName());

        if (item.getName().equals(mContext.getResources().getString(R.string.goodsManage))) {//商品管理
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_goods);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.more))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_more);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.staffManage))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_staff);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.vip))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_vip);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.putOrder))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_put_order);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.getOrder))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_get_order);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.rejectedGood))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_rejected);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.detele))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_detele);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.orderManage))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_order);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.reportForm))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_form);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.inventory))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_inventory);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.set))) {
            helper.setImageResource(R.id.iv_function_icon, R.drawable.icon_set);
        }
    }
}
