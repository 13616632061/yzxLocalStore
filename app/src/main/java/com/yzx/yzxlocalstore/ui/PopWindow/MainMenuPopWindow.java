package com.yzx.yzxlocalstore.ui.PopWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cheng.channel.Channel;
import com.cheng.channel.ChannelView;
import com.yzx.lib.util.ScreenUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter.MainActivityPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2019/6/25.
 */

public class MainMenuPopWindow extends PopupWindow implements ChannelView.OnChannelListener {

    private Context mContext;
    private View view;
    private ImageView iv_close;
    private ChannelView chanel_type;
    private MainActivityPresenter mPresenter;

    public MainMenuPopWindow(Context context, MainActivityPresenter mPresenter) {
        super(context);
        mContext = context;
        this.mPresenter = mPresenter;
        view = View.inflate(context, R.layout.main_menu_layout, null);

        initSet();
        initView();
    }

    private void initView() {
        iv_close = view.findViewById(R.id.iv_close);
        chanel_type = view.findViewById(R.id.chanel_type);
        chanel_type.setOnChannelItemClickListener(this);

        List<Channel> myChannelList = new ArrayList<>();
        for (Channel channel : mPresenter.getTypeChannel()) {
            myChannelList.add(channel);
        }
        chanel_type.setChannelFixedCount(1);
        chanel_type.addPlate("分类栏目", myChannelList);
        chanel_type.inflateData();
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    private void initSet() {
        this.setContentView(view);
        //sdk > 21 解决 标题栏没有办法遮罩的问题
        this.setClippingEnabled(false);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        if (ScreenUtil.isAllScreenDevice(mContext) && !ScreenUtil.isNavigationBarExist((Activity) mContext)) {
            this.setHeight(WindowManager.LayoutParams.MATCH_PARENT);//屏幕的高
        } else {
            this.setHeight(ScreenUtil.getScreenHeight(mContext));//屏幕的高
        }
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.AnimationWindow);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x80000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
//        view.setOnTouchListener(new View.OnTouchListener() {
//
//            public boolean onTouch(View v, MotionEvent event) {
//
//                int height = view.findViewById(R.id.layout_content).getTop();
//                int y = (int) event.getY();
//                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    if (y < height) {
//                        dismiss();
//                    }
//                }
//                return true;
//            }
//        });
    }

    @Override
    public void channelItemClick(int position, Channel channel) {
        TypeBean typeBean = (TypeBean) channel.getObj();
        switch (typeBean.getChannelTag()) {
            case "goodsManage":
                ARouter.getInstance().build(RouteMap.ROUTE_GOODS_MANAGE_ACTIVITY).navigation();
                break;
        }
    }

    @Override
    public void channelEditFinish(List<Channel> channelList) {

    }

    @Override
    public void channelEditStart() {

    }
}
