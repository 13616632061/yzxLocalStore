package com.yzx.yzxlocalstore.ui.PopWindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter.GoodsListFragmentPresenter;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.presenter.GoodsTypeFragmentPresenter;

/**
 * Created by Administrator on 2019/7/4.
 */

public class TipsPopWindow extends BasePopupWindow implements View.OnClickListener {

    private Context mContext;
    private View view;
    private TextView tv_title;
    private TextView tv_msg;
    private TextView btn_sure;
    private TextView btn_cancel;
    private String title, msg;
    private Object mPresenter;
    private int type;//操作类型

    public TipsPopWindow(Context mContext, String title, String msg, Object mPresenter, int type) {
        super(mContext);
        this.mContext = mContext;
        this.title = title;
        this.msg = msg;
        this.mPresenter = mPresenter;
        this.type = type;
        view = View.inflate(mContext, R.layout.layout_tips_pop, null);

        initSet(view);
        hideStatusBar(view);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sure:
                sureType(type);
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }

    private void sureType(int type) {
        switch (type) {
            case 1://删除分类操作
                ((GoodsTypeFragmentPresenter) mPresenter).deleteGoodsType();
                dismiss();
                break;
            case 2://删除商品信息操作
                ((GoodsListFragmentPresenter) mPresenter).deteleGoodsInfo();
                dismiss();
                break;
            case 3://上架商品信息操作
                ((GoodsListFragmentPresenter) mPresenter).upShelfGoodsInfo();
                dismiss();
                break;
            case 4://下架商品信息操作
                ((GoodsListFragmentPresenter) mPresenter).dowmShelfGoodsInfo();
                dismiss();
                break;
        }
    }
}
