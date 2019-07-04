package com.yzx.yzxlocalstore.ui.PopWindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yzx.yzxlocalstore.R;

/**
 * Created by Administrator on 2019/7/4.
 */

public class TipsPopWindow extends PopupWindow implements View.OnClickListener {

    private Context mContext;
    private View view;
    private TextView tv_title;
    private TextView tv_msg;
    private TextView btn_sure;
    private TextView btn_cancel;
    private String title, msg;

    public TipsPopWindow(Context mContext, String title, String msg) {
        super(mContext);
        this.mContext = mContext;
        this.title = title;
        this.msg = msg;
        view = View.inflate(mContext, R.layout.layout_tips_pop, null);

        initSet();
        initView();
    }

    private void initView() {
        tv_title = view.findViewById(R.id.tv_title);
        tv_msg = view.findViewById(R.id.tv_msg);
        btn_sure = view.findViewById(R.id.btn_sure);
        btn_cancel = view.findViewById(R.id.btn_cancel);

        tv_title.setText(title);
        tv_msg.setText(msg);
        btn_sure.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

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
