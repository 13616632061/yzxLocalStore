package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.ui.Adapter.GoodsListFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter.GoodsListFragmentPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsListFragment extends BaseFragment implements IGoodsListFragmentView {


    @InjectView(R.id.tv_all_nums)
    TextView tvAllNums;
    @InjectView(R.id.tv_all_type)
    TextView tvAllType;
    @InjectView(R.id.tv_lack_type)
    TextView tvLackType;
    @InjectView(R.id.tv_warning_type)
    TextView tvWarningType;
    @InjectView(R.id.iv_all_select)
    ImageView ivAllSelect;
    @InjectView(R.id.list)
    RecyclerView list;


    private GoodsListFragmentPresenter mPresenter;
    private GoodsListFragmentAdapter mAdapter;
    private List<GoodsInfo> mData = new ArrayList<>();
    private Context mContext;
    private int mPage = 1;
    private boolean isAllSelect = false;//是否全选


    @Override
    protected int setContentViewId() {
        return R.layout.goods_list_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mContext = getActivity();
        EventBus.getDefault().register(this);
        mPresenter = new GoodsListFragmentPresenter(this);
        mPresenter.initAdapter();
    }


    @Override
    protected void loadData() {
        mPresenter.getGoodsInfo(mPage);
    }

    @OnClick({R.id.iv_all_select, R.id.btn_add_goods, R.id.btn_delete_goods, R.id.btn_up_shelf, R.id.btn_down_shelf, R.id.btn_import, R.id.btn_export, R.id.btn_print})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_all_select://全部选中
                mPresenter.editGoodsInfoSelectStatus(0, 0);
                break;
            case R.id.btn_add_goods://新增商品
                mPresenter.addGoodsInfo();
                break;
            case R.id.btn_delete_goods://删除商品
                break;
            case R.id.btn_up_shelf://上架商品
                break;
            case R.id.btn_down_shelf://下架商品
                break;
            case R.id.btn_import://导入商品
                break;
            case R.id.btn_export://导出商品
                break;
            case R.id.btn_print://打印标签
                break;
        }
    }

    @Override
    public void initAdapter() {
        mAdapter = new GoodsListFragmentAdapter(mContext, R.layout.item_good_info_list, mData);
        list.setAdapter(mAdapter);
        list.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_edit://编辑
                        break;
                    case R.id.iv_select://选中状态
                        mPresenter.editGoodsInfoSelectStatus(1, position);
                        break;
                }
            }
        });
    }

    @Override
    public GoodsListFragmentAdapter getAdapter() {
        return mAdapter;
    }

    /**
     * 商品数据
     *
     * @return
     */
    @Override
    public List<GoodsInfo> getData() {
        return mData;
    }

    /**
     * 商品全选状态显示
     */
    @Override
    public void showAllSelectStatus() {
        if (isAllSelect) {
            ivAllSelect.setImageResource(R.drawable.select);
        } else {
            ivAllSelect.setImageResource(R.drawable.unselect);
        }
    }

    @Override
    public void setAllSelect(boolean isAllSelect) {
        this.isAllSelect = isAllSelect;
    }

    /**
     * 是否全部选中
     *
     * @return
     */
    @Override
    public boolean isAllSelect() {
        return isAllSelect;
    }

    @Override
    public void allGoodsInfo() {

    }

    @Override
    public void lackGoodsInfo() {

    }

    @Override
    public void warningGoodsInfo() {

    }

    @Override
    public void addGoodsInfo() {
        ARouter.getInstance().build(RouteMap.ROUTE_ADD_GOODS_INFO_ACTIVITY).navigation();
    }

    @Override
    public void deteleGoodsInfo() {

    }

    @Override
    public void upShelfGoodsInfo() {

    }

    @Override
    public void dowmShelfGoodsInfo() {

    }

    @Override
    public void importGoodsInfo() {

    }

    @Override
    public void exportGoodsInfo() {

    }

    @Override
    public void printLabel() {

    }

    @Override
    public void firstPage() {

    }

    @Override
    public void lastPage() {

    }

    @Override
    public void previousPage() {

    }

    @Override
    public void nextPage() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEven(MessageEvent msg) {
        if (msg.getKey().contains("addGoodsInfoSuccess")) {
            mPresenter.getGoodsInfo(mPage);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);

    }
}
