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
        ImageView iv_function_icon = helper.getView(R.id.iv_function_icon);

        if (item.getName().equals(mContext.getResources().getString(R.string.goodsManage))) {//商品管理
            Glide.with(mContext).load(R.drawable.icon_goods).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.more))) {
            Glide.with(mContext).load(R.drawable.icon_more).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.staffManage))) {
            Glide.with(mContext).load(R.drawable.icon_staff).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.vip))) {
            Glide.with(mContext).load(R.drawable.icon_vip).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.putOrder))) {
            Glide.with(mContext).load(R.drawable.icon_put_order).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.getOrder))) {
            Glide.with(mContext).load(R.drawable.icon_get_order).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.rejectedGood))) {
            Glide.with(mContext).load(R.drawable.icon_rejected).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.detele))) {
            Glide.with(mContext).load(R.drawable.icon_detele).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.orderManage))) {
            Glide.with(mContext).load(R.drawable.icon_order).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.reportForm))) {
            Glide.with(mContext).load(R.drawable.icon_form).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.inventory))) {
            Glide.with(mContext).load(R.drawable.icon_inventory).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        } else if (item.getName().equals(mContext.getResources().getString(R.string.set))) {
            Glide.with(mContext).load(R.drawable.icon_set).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_function_icon);
        }
    }
}
