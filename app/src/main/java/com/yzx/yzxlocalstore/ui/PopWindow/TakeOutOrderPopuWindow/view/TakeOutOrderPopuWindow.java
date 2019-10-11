package com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.ui.Adapter.TakeOutOrderPopuWindowAdapter;
import com.yzx.yzxlocalstore.ui.PopWindow.BasePopupWindow;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.presenter.MainMenuPopWindowPresenter;
import com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.presenter.TakeOutOrderPopuWindowPresenter;

/**
 * Created by Administrator on 2019/10/10.
 */

public class TakeOutOrderPopuWindow extends BasePopupWindow implements ITakeOutOrderPopuWindowImp, View.OnClickListener {

    private Context mContext;
    private View view;
    private TextView tvExit;
    private RecyclerView list;

    private TakeOutOrderPopuWindowPresenter mPresenter;

    public static TakeOutOrderPopuWindow takeOutOrderPopuWindowInstance;

    public static TakeOutOrderPopuWindow getInstance(Context context) {
        if (takeOutOrderPopuWindowInstance == null) {
            synchronized (TakeOutOrderPopuWindow.class) {
                if (takeOutOrderPopuWindowInstance == null) {
                    takeOutOrderPopuWindowInstance = new TakeOutOrderPopuWindow(context);
                }
            }
        }
        return takeOutOrderPopuWindowInstance;
    }


    private TakeOutOrderPopuWindow(Context context) {
        super(context);
        mContext = context;
        view = View.inflate(context, R.layout.take_out_order_layout, null);
        initSet(view);
        hideStatusBar(view);

        initView();
    }

    /**
     * 初始化视图
     */
    @Override
    public void initView() {
        this.setWidth(ScreenUtils.getScreenWidth() * 3 / 5 - ConvertUtils.dp2px(45));
        ColorDrawable dw = new ColorDrawable(mContext.getResources().getColor(R.color.whilte));
        this.setBackgroundDrawable(dw);
        this.setFocusable(false);
        this.setAnimationStyle(R.style.take_out_order_anim_style);

        tvExit = view.findViewById(R.id.tv_exit);
        list = view.findViewById(R.id.list);
        tvExit.setOnClickListener(this);

        mPresenter = new TakeOutOrderPopuWindowPresenter(this);
        mPresenter.initTakeOutOrderPopuWindowAdapter();
        mPresenter.getPutOrderData();

    }

    /**
     * 初始化数据列表
     *
     * @return
     */
    @Override
    public TakeOutOrderPopuWindowAdapter initTakeOutOrderPopuWindowAdapter() {
        TakeOutOrderPopuWindowAdapter adapter = new TakeOutOrderPopuWindowAdapter(R.layout.item_take_out_order, mPresenter.getData());
        list.setLayoutManager(new LinearLayoutManager(mContext));
        list.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.takeOutOrder(mPresenter.getData().get(position));
                mPresenter.exit();
            }
        });
        return adapter;
    }

    @Override
    public void exit() {
        dismiss();
        takeOutOrderPopuWindowInstance = null;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_exit:
                mPresenter.exit();
                break;
        }
    }

}
