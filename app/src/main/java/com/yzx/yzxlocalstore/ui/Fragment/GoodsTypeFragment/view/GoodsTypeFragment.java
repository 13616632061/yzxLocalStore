package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Adapter.GoodsTypeFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.presenter.GoodsTypeFragmentPresenter;
import com.yzx.yzxlocalstore.ui.PopWindow.GoodsTypePopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypeFragment extends BaseFragment implements IGoodsTypeFragmentView {
    @InjectView(R.id.tv_goods_type_num)
    TextView tvGoodsTypeNum;
    @InjectView(R.id.iv_all_select)
    ImageView ivAllSelect;
    @InjectView(R.id.list)
    RecyclerView list;
    @InjectView(R.id.layout_goods_type)
    RelativeLayout layoutGoodsType;

    private GoodsTypeFragmentAdapter mAdapter;
    private List<GoodsType> datas = new ArrayList<>();
    private Context mContext;
    private GoodsTypeFragmentPresenter mPresenter;

    @Override
    protected int setContentViewId() {
        return R.layout.goods_type_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mContext = getActivity();
        mPresenter = new GoodsTypeFragmentPresenter(this);
        mPresenter.initAdapter();
    }

    @Override
    protected void loadData() {

    }

    @OnClick({R.id.iv_all_select, R.id.btn_add, R.id.btn_delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_all_select:
                break;
            case R.id.btn_add:
                mPresenter.addGoodsType();
                break;
            case R.id.btn_delete:
                break;
        }
    }

    //初始化适配器
    @Override
    public void initAdapter() {
        mAdapter = new GoodsTypeFragmentAdapter(R.layout.layout_goods_type_header, datas);
        list.setAdapter(mAdapter);
        list.setLayoutManager(new LinearLayoutManager(mContext));
    }

    //新增分类
    @Override
    public void addGoodsType() {
        GoodsTypePopWindow goodsTypePopWindow = new GoodsTypePopWindow(mContext, getResources().getString(R.string.add_goods_type));
        goodsTypePopWindow.showAsDropDown(layoutGoodsType, Gravity.NO_GRAVITY, 0, 0);
    }

    //删除分类
    @Override
    public void deleteGoodsType() {

    }

    //编辑分类
    @Override
    public void editGoodsType() {

    }


}
