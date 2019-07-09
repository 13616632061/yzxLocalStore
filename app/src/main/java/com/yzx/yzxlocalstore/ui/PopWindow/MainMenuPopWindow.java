package com.yzx.yzxlocalstore.ui.PopWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
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

public class MainMenuPopWindow extends BasePopupWindow implements ChannelView.OnChannelListener {

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
        initSet(view);
        hideStatusBar(view);
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
