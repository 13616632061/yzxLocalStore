package com.yzx.yzxlocalstore.ui.Adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter.ManageTypeAdapter;

/**
 * Created by Administrator on 2019/10/8.
 */

public class CustomGoodBarAdapter  extends RecyclerTabLayout.Adapter<CustomGoodBarAdapter.ViewHolder> {


    public CustomGoodBarAdapter(ViewPager viewPager) {
        super(viewPager);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBar = itemView.findViewById(R.id.tv_manage_type);
            tvBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getViewPager().setCurrentItem(getAdapterPosition());
                }
            });
        }
    }
}
