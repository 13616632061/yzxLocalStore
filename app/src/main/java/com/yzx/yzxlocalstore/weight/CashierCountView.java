package com.yzx.yzxlocalstore.weight;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.yzx.yzxlocalstore.R;


/**
 * Created by Administrator on 2019/8/1.
 * 收银计算view
 */

public class CashierCountView extends FrameLayout {

    private Context mContext;
    private View view;

    public CashierCountView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public CashierCountView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CashierCountView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CashierCountView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context mContext) {
        this.mContext = mContext;
        view = View.inflate(mContext, R.layout.cashier_count_layout, null);
    }
}
