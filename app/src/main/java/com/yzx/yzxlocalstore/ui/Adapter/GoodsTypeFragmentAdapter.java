package com.yzx.yzxlocalstore.ui.Adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsType;

import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypeFragmentAdapter extends BaseQuickAdapter<GoodsType, BaseViewHolder> {

    public GoodsTypeFragmentAdapter(int layoutResId, @Nullable List<GoodsType> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsType item) {
        if (helper.getAdapterPosition() % 2 == 0) {
            helper.setBackgroundRes(R.id.layout_item, R.color.white);
        } else {
            helper.setBackgroundRes(R.id.layout_item, R.color.color_F8F8FF);
        }

        //分类名
        helper.setText(R.id.tv_type_name, item.getTypeName());
        //排序号
        helper.setText(R.id.tv_sort, item.getSort() + "");
        //是否选中
        if (item.getIsSelect()) {
            helper.setImageResource(R.id.iv_select, R.drawable.select);
        } else {
            helper.setImageResource(R.id.iv_select, R.drawable.unselect);
        }
        //状态
        if (item.getStatus()) {
            helper.setText(R.id.tv_status, mContext.getResources().getString(R.string.enable));
        } else {
            helper.setText(R.id.tv_status, mContext.getResources().getString(R.string.forbidden));
        }
        helper.addOnClickListener(R.id.iv_select);
        helper.addOnClickListener(R.id.tv_edit);
    }
}
