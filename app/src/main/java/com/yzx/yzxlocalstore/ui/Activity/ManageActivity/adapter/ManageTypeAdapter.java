package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.ManageType;

import java.util.List;

/**
 * Created by lyf on 2019/5/7.
 */

public class ManageTypeAdapter extends RecyclerTabLayout.Adapter<ManageTypeAdapter.ViewHolder> {

    private Context context;
    private List<ManageType> data;

    public ManageTypeAdapter(Context context, ViewPager viewPager, List<ManageType> data) {
        super(viewPager);
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item_manege_type, null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.tv_manage_type.setText(data.get(position).getName());

        Drawable drawable = null;
        if (position == getCurrentIndicatorPosition()) {
            drawable = context.getResources().getDrawable(data.get(position).getSelectIcon());
        } else {
            drawable = context.getResources().getDrawable(data.get(position).getUnSelectIcon());
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        viewHolder.tv_manage_type.setCompoundDrawables(null, drawable, null, null);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_manage_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_manage_type = itemView.findViewById(R.id.tv_manage_type);
        }
    }
}
