package com.yzx.yzxlocalstore.ui.PopWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yzx.lib.util.ScreenUtil;
import com.yzx.yzxlocalstore.R;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypePopWindow extends PopupWindow implements View.OnClickListener {

    private View view;
    private Context mContext;
    private TextView tv_title;
    private EditText et_type_name;
    private EditText et_sort;
    private Button btn_cancel;
    private Button btn_sure;

    public GoodsTypePopWindow(Context context, String title) {
        super(context);
        mContext = context;
        view = View.inflate(context, R.layout.layout_goods_type_pop, null);

        initSet();
        initView(title);
    }

    private void initView(String title) {
        tv_title = view.findViewById(R.id.tv_title);
        et_type_name = view.findViewById(R.id.et_type_name);
        et_sort = view.findViewById(R.id.et_sort);
        btn_sure = view.findViewById(R.id.btn_sure);
        btn_cancel = view.findViewById(R.id.btn_cancel);

        tv_title.setText(title);
        btn_cancel.setOnClickListener(this);
        btn_sure.setOnClickListener(this);
    }

    private void initSet() {
        this.setContentView(view);
        //sdk > 21 解决 标题栏没有办法遮罩的问题
        this.setClippingEnabled(false);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.MATCH_PARENT);//屏幕的高
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.AnimationWindow);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x80000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sure:
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }
}
