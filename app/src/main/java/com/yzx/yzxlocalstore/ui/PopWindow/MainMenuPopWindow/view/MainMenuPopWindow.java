package com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.cheng.channel.Channel;
import com.cheng.channel.ChannelView;
import com.yzx.lib.util.ScreenUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter.MainActivityPresenter;
import com.yzx.yzxlocalstore.ui.PopWindow.BasePopupWindow;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.presenter.MainMenuPopWindowPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2019/6/25.
 */

public class MainMenuPopWindow extends BasePopupWindow implements ChannelView.OnChannelListener {

    private Context mContext;
    private View view;
    private ImageView iv_close;
    private TextView tv_close;
    private ChannelView chanel_type;
    private MainMenuPopWindowPresenter mPresenter;

    public MainMenuPopWindow(Context context) {
        super(context);
        mContext = context;
        mPresenter = new MainMenuPopWindowPresenter(context, this);
        view = View.inflate(context, R.layout.main_menu_layout, null);
        initSet(view);
        hideStatusBar(view);
        initView();

    }

    private void initView() {
        iv_close = view.findViewById(R.id.iv_close);
        chanel_type = view.findViewById(R.id.chanel_type);
        tv_close = view.findViewById(R.id.tv_close);
        chanel_type.setOnChannelItemClickListener(this);


        chanel_type.setChannelFixedCount(0);
        chanel_type.addPlate(mContext.getResources().getString(R.string.common_columns), mPresenter.getCommonlyType());
        chanel_type.addPlate("更多栏目", mPresenter.getMoreType());
        chanel_type.setSubTitleName("长按栏目或者点击编辑，进行拖动排序或删除");
        chanel_type.setSubTitleTextColor(mContext.getResources().getColor(R.color.color_f5260b));
        chanel_type.inflateData();
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * 正常状态点击事件
     *
     * @param position
     * @param channel
     */
    @Override
    public void channelItemClick(int position, Channel channel) {
        mPresenter.typeItemClick(position, channel);
    }

    /**
     * 编辑完成
     *
     * @param channelList
     */
    @Override
    public void channelEditFinish(List<Channel> channelList) {
        mPresenter.typeEditFinish(channelList);
    }

    /**
     * 开始编辑
     */
    @Override
    public void channelEditStart() {

    }

    /**
     * 获取其他栏目
     *
     * @return
     */
    public List<Channel> getOtherChannel() {
        return chanel_type.getOtherChannel().get(0);
    }
}
