package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.ui.Adapter.GoodsListFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter.GoodsListFragmentPresenter;
import com.yzx.yzxlocalstore.ui.PopWindow.TipsPopWindow;

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
    @InjectView(R.id.layout_goods_list)
    RelativeLayout layoutGoodsList;


    private GoodsListFragmentPresenter mPresenter;
    private GoodsListFragmentAdapter mAdapter;
    private List<GoodsInfo> mData = new ArrayList<>();
//    private Context mContext;
    private int mPage = 1;
    private boolean isAllSelect = false;//是否全选


    @Override
    protected int setContentViewId() {
        return R.layout.goods_list_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        EventBus.getDefault().register(this);
        mPresenter = new GoodsListFragmentPresenter(this);
        mPresenter.initAdapter();
    }


    @Override
    protected void loadData() {
        mPresenter.getGoodsInfo(mPage, 0);
        mPresenter.setLackGoodsInfom();
        mPresenter.setWarningGoodsNum();

    }

    @OnClick({R.id.iv_all_select, R.id.btn_add_goods, R.id.btn_delete_goods, R.id.btn_up_shelf, R.id.btn_down_shelf, R.id.btn_import, R.id.btn_export, R.id.btn_print,
            R.id.tv_all_type, R.id.tv_lack_type, R.id.tv_warning_type})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.iv_all_select://全部选中
                mPresenter.editGoodsInfoSelectStatus(0, 0);
                break;
            case R.id.tv_all_type://全部商品
                mPresenter.getGoodsInfo(mPage, 0);
                break;
            case R.id.tv_lack_type://缺货商品
                mPresenter.getGoodsInfo(mPage, 1);
                break;
            case R.id.tv_warning_type://库存预警商品
                mPresenter.getGoodsInfo(mPage, 2);
                break;
            case R.id.btn_add_goods://新增商品
                mPresenter.addGoodsInfo();
                break;
            case R.id.btn_delete_goods://删除商品
                mPresenter.showHandleGoodsInfoTipMsg(1);
                break;
            case R.id.btn_up_shelf://上架商品
                mPresenter.showHandleGoodsInfoTipMsg(2);
                break;
            case R.id.btn_down_shelf://下架商品
                mPresenter.showHandleGoodsInfoTipMsg(3);
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
        mAdapter = new GoodsListFragmentAdapter(getActivity(), R.layout.item_good_info_list, mData);
        list.setAdapter(mAdapter);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_edit://编辑
                        mPresenter.goToEditGoodsInfo(mData.get(position));
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

    /**
     * 所有商品数量
     *
     * @param allGoodsNum
     */
    @Override
    public void setAllGoodsNum(String allGoodsNum) {
        tvAllType.setText(getResources().getString(R.string.alls) + "(" + allGoodsNum + ")");
    }

    /**
     * 是否选中所有商品类型
     *
     * @param isSelectAllGoods
     */
    @Override
    public void isSelectAllGoodsType(boolean isSelectAllGoods) {
        if (isSelectAllGoods) {
            tvAllType.setTextColor(getResources().getColor(R.color.color_f5260b));
        } else {
            tvAllType.setTextColor(getResources().getColor(R.color.color_707070));
        }
    }

    /**
     * 缺货商品数量
     *
     * @param lackGoodsNum
     */
    @Override
    public void setLackGoodsInfom(String lackGoodsNum) {
        tvLackType.setText(getResources().getString(R.string.goods_out_stock) + "(" + lackGoodsNum + ")");
    }

    /**
     * 是否选中缺货商品类型
     *
     * @param iisSelectLackGoods
     */
    @Override
    public void isSelectLackGoodsType(boolean iisSelectLackGoods) {
        if (iisSelectLackGoods) {
            tvLackType.setTextColor(getResources().getColor(R.color.color_f5260b));
        } else {
            tvLackType.setTextColor(getResources().getColor(R.color.color_707070));
        }
    }

    /**
     * 库存预警
     *
     * @param warningGoodsNum
     */
    @Override
    public void setWarningGoodsNum(String warningGoodsNum) {
        tvWarningType.setText(getResources().getString(R.string.waring_store) + "(" + warningGoodsNum + ")");

    }

    /**
     * 是否选中库存预警商品类型
     *
     * @param isSelectWarningGoods
     */
    @Override
    public void isSelectWarningGoodsType(boolean isSelectWarningGoods) {
        if (isSelectWarningGoods) {
            tvWarningType.setTextColor(getResources().getColor(R.color.color_f5260b));
        } else {
            tvWarningType.setTextColor(getResources().getColor(R.color.color_707070));
        }
    }

    /**
     * 编辑商品
     */
    @Override
    public void goToEditGoodsInfo(GoodsInfo goodInfo) {
        ARouter.getInstance().build(RouteMap.ROUTE_ADD_GOODS_INFO_ACTIVITY)
                .withInt("type", 2)
                .withParcelable("mGoodsInfo", goodInfo)
                .navigation();
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
        ARouter.getInstance().build(RouteMap.ROUTE_ADD_GOODS_INFO_ACTIVITY).withInt("type", 1).navigation();
    }

    /**
     * 删除商品
     */
    @Override
    public void deteleGoodsInfo() {
        TipsPopWindow tipsPopWindow = new TipsPopWindow(getActivity(), getResources().getString(R.string.reminder), getResources().getString(R.string.sure_delete_item), mPresenter, 2);
        tipsPopWindow.showAsDropDown(layoutGoodsList, Gravity.NO_GRAVITY, 0, 0);
    }

    /**
     * 上架商品
     */
    @Override
    public void upShelfGoodsInfo() {
        TipsPopWindow tipsPopWindow = new TipsPopWindow(getActivity(), getResources().getString(R.string.reminder), getResources().getString(R.string.sure_up_shelf_item), mPresenter, 3);
        tipsPopWindow.showAsDropDown(layoutGoodsList, Gravity.NO_GRAVITY, 0, 0);
    }

    /**
     * 下架商品
     */
    @Override
    public void dowmShelfGoodsInfo() {
        TipsPopWindow tipsPopWindow = new TipsPopWindow(getActivity(), getResources().getString(R.string.reminder), getResources().getString(R.string.sure_down_shelf_item), mPresenter, 4);
        tipsPopWindow.showAsDropDown(layoutGoodsList, Gravity.NO_GRAVITY, 0, 0);
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

    /**
     * 显示提示信息
     *
     * @param type
     */
    @Override
    public void showErrorMsg(int type) {
        switch (type) {
            case 1:
                Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.selete_delete_goods_item), Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.selete_up_shelf_goods_item), Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.selete_down_shelf_goods_item), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEven(MessageEvent msg) {
        if (msg.getKey().contains("addGoodsInfoSuccess")) {
            mPresenter.getGoodsInfo(mPage, 0);
            mPresenter.setLackGoodsInfom();
            mPresenter.setWarningGoodsNum();
        }
    }


}
