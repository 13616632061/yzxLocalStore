package com.yzx.yzxlocalstore.ui.PopWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.cheng.channel.Channel;
import com.cheng.channel.ChannelView;
import com.yzx.lib.util.ScreenUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.ManageType;

import java.util.ArrayList;
import java.util.List;

import static com.yzx.lib.util.ScreenUtil.isNavigationBarExist;

/**
 * Created by Administrator on 2019/6/25.
 */

public class MainMenuPopWindow extends PopupWindow {

    private Context mContext;
    private View view;
    private ImageView iv_close;
    private ChannelView chanel_type;

    public MainMenuPopWindow(Context context) {
        super(context);
        mContext = context;
        view = View.inflate(context, R.layout.main_menu_layout, null);

        initSet();
        initView();
    }

    private void initView() {
        iv_close = view.findViewById(R.id.iv_close);
        chanel_type = view.findViewById(R.id.chanel_type);

        String[] myChannel = {"要闻", "视频", "新时代", "娱乐", "体育", "军事", "NBA", "国际", "科技", "财经", "汽车", "电影", "游戏", "独家", "房产",
                "图片", "时尚", "呼和浩特", "三打白骨精"};
//        List<ManageType> myChannelList = new ArrayList<>();
        List<Channel> myChannelList = new ArrayList<>();
        for (String name : myChannel) {
            Channel channel = new Channel(name);
            myChannelList.add(channel);
        }
        chanel_type.setChannelFixedCount(5);
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
}
