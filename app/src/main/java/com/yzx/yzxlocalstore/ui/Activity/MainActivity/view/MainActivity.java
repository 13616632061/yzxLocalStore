package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter.MainActivityPresenter;
import com.yzx.yzxlocalstore.ui.Adapter.MainBottomTypeAdapter;
import com.yzx.yzxlocalstore.ui.Adapter.MainLeftSaleGoodsListAdapter;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.view.MainMenuPopWindow;
import com.yzx.yzxlocalstore.weight.CashierCountView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

@Route(path = RouteMap.ROUTE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity implements IMainActivityView {

    @InjectView(R.id.list_bottom)
    RecyclerView listBottom;
    @InjectView(R.id.list_left)
    RecyclerView listLeft;
    @InjectView(R.id.tv_total_weight)
    TextView tvTotalWeight;
    @InjectView(R.id.tv_total_good_num)
    TextView tvTotalGoodNum;
    @InjectView(R.id.tv_total_price)
    TextView tvTotalPrice;
    @InjectView(R.id.cashier_count_view)
    CashierCountView cashierCountView;
    private MainActivityPresenter mPresenter;
    private MainBottomTypeAdapter mBottomTypeAdapter;
    private List<TypeBean> mBottomTypeData = new ArrayList<>();

    private MainLeftSaleGoodsListAdapter mainLeftSaleGoodsListAdapter;

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        mPresenter = new MainActivityPresenter(this);
        //初始化底部功能信息
        mPresenter.initTypeChannel();
        mPresenter.setBottomTypeView();
        mPresenter.getBottomType();
        //初始化左边要销售的商品信息
        mPresenter.setLeftSaleGoodsListView();
    }


    //显示更多分类信息
    @Override
    public void showMoreTypeChannel() {
        MainMenuPopWindow menuPopWindow = new MainMenuPopWindow(this);
        menuPopWindow.showAtLocation(findViewById(R.id.main_activity), Gravity.NO_GRAVITY, 0, 0);

    }

    /**
     * 设置底部功能分类视图
     */
    @Override
    public void setBottomTypeView() {
        mBottomTypeAdapter = new MainBottomTypeAdapter(this, R.layout.item_main_bottom_type, mBottomTypeData);
        listBottom.setAdapter(mBottomTypeAdapter);
        listBottom.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mBottomTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.setBottomTypeOnClick(mBottomTypeData.get(position).getName());
            }
        });

    }

    /**
     * 底部功能管理分类适配器
     *
     * @return
     */
    @Override
    public MainBottomTypeAdapter mainBottomTypeAdapter() {
        return mBottomTypeAdapter;
    }

    /**
     * 底部功能管理分类数据
     *
     * @return
     */
    @Override
    public List<TypeBean> mBottomTypeData() {
        return mBottomTypeData;
    }

    /**
     * 要销售的商品列表
     */
    @Override
    public void setLeftSaleGoodsListView() {
        mainLeftSaleGoodsListAdapter = new MainLeftSaleGoodsListAdapter(this, R.layout.item_main_left_good_list, mPresenter.saleGoodsInfoData());
        listLeft.setAdapter(mainLeftSaleGoodsListAdapter);
        listLeft.setLayoutManager(new LinearLayoutManager(this));
        mainLeftSaleGoodsListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.setSelectSaleGoodsInfoItem(position);
            }
        });
    }

    /**
     * 销售的商品列表的Adapter
     *
     * @return
     */
    @Override
    public MainLeftSaleGoodsListAdapter mainLeftSaleGoodsListAdapter() {
        return mainLeftSaleGoodsListAdapter;
    }

    /**
     * 最后加入销售的商品列表定位到可见
     */
    @Override
    public void LeftSaleGoodsListScrollToPosition() {
        listLeft.scrollToPosition(mPresenter.saleGoodsInfoData().size() - 1);
    }

    /**
     * 销售商品的总重量
     */
    @Override
    public void setTotalWeight() {

    }

    /**
     * 销售商品的总数量
     */
    @Override
    public void setTotalGoodNum(String totalGoodNum) {
        tvTotalGoodNum.setText(totalGoodNum);
    }

    /**
     * 销售商品的总价格
     */
    @Override
    public void setTotalPrice(String totalPrice) {
        tvTotalPrice.setText(totalPrice);
    }

    /**
     * 应收金额
     *
     * @param receivableMoney
     */
    @Override
    public void setReceivableMoney(String receivableMoney) {
        cashierCountView.setReceivableMoney(receivableMoney);
    }

    /**
     * 找零
     */
    @Override
    public void setChangeMoney() {
        cashierCountView.setChangeMoney();
    }

    /**
     * 选择支付方式
     */
    @Override
    public void selcetPayment() {
        cashierCountView.setPaymentType(new CashierCountView.paymentType() {
            @Override
            public void membershipPayment() {//会员支付
                showToast("选择了会员支付");
            }

            @Override
            public void cashPayment() {//现金支付
                showToast("选择了现金支付");
            }

            @Override
            public void mobilePayment() {//移动支付
                showToast("选择了移动支付");
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvenBus(Map<Object, Object> map) {
        if (map.containsKey("updateManageType")) {//更新底部管理分类
            mPresenter.getBottomType();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
