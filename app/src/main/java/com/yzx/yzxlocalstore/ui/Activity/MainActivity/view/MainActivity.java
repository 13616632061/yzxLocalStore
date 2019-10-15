package com.yzx.yzxlocalstore.ui.Activity.MainActivity.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.apkfuns.logutils.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.util.ScanGunKeyEventHelper;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter.MainActivityPresenter;
import com.yzx.yzxlocalstore.ui.Adapter.MainBottomTypeAdapter;
import com.yzx.yzxlocalstore.ui.Adapter.MainLeftSaleGoodsListAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.view.ShortcutBarFragment;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.view.WeightBarFragment;
import com.yzx.yzxlocalstore.ui.PopWindow.MainMenuPopWindow.view.MainMenuPopWindow;
import com.yzx.yzxlocalstore.ui.PopWindow.TakeOutOrderPopuWindow.view.TakeOutOrderPopuWindow;
import com.yzx.yzxlocalstore.weight.CashierCountView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

@Route(path = RouteMap.ROUTE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity implements IMainActivityView, ScanGunKeyEventHelper.OnScanSuccessListener {

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
    @InjectView(R.id.tv_shortcut_bar)
    TextView tvShortcutBar;
    @InjectView(R.id.tv_weight_bar)
    TextView tvWeightBar;
    @InjectView(R.id.bar_content)
    FrameLayout barContent;
    @InjectView(R.id.layout_midle)
    RelativeLayout layoutMidle;
    @InjectView(R.id.tv_cur_time)
    TextView tvCurTime;

    private MainActivityPresenter mPresenter;
    private MainBottomTypeAdapter mBottomTypeAdapter;
    private List<TypeBean> mBottomTypeData = new ArrayList<>();


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
        mPresenter.selcetPayment();
        mPresenter.showGoodBarPosition(0);
        mPresenter.showCurTime();
    }

    @OnClick({R.id.layout_shortcut_bar, R.id.layout_weight_bar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_shortcut_bar://快捷栏
                mPresenter.showGoodBarPosition(0);
                break;
            case R.id.layout_weight_bar://计重栏
                mPresenter.showGoodBarPosition(1);
                break;
        }
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
    public MainLeftSaleGoodsListAdapter setLeftSaleGoodsListView() {
        MainLeftSaleGoodsListAdapter mainLeftSaleGoodsListAdapter = new MainLeftSaleGoodsListAdapter(this, R.layout.item_main_left_good_list, mPresenter.saleGoodsInfoData());
        listLeft.setAdapter(mainLeftSaleGoodsListAdapter);
        listLeft.setLayoutManager(new LinearLayoutManager(this));
        mainLeftSaleGoodsListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPresenter.setSelectSaleGoodsInfoItem(position);
            }
        });
        return mainLeftSaleGoodsListAdapter;
    }


    /**
     * 最后加入销售的商品列表定位到可见
     */
    @Override
    public void LeftSaleGoodsListScrollToPosition(int position) {
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
     * 实收金额
     *
     * @param money
     */
    @Override
    public void setReceiptsMoney(String money) {
        cashierCountView.setReceiptsMoney(money);
    }

    /**
     * 找零
     */
    @Override
    public void setChangeMoney() {
        cashierCountView.setChangeMoney();
    }


    @Override
    public double getChangeMoney() {
        return cashierCountView.getChangeMoney();
    }

    /**
     * 选择支付方式
     */
    @Override
    public void selcetPayment() {
        cashierCountView.setPaymentType(new CashierCountView.paymentType() {
            @Override
            public void membershipPayment() {//会员支付
                mPresenter.createOrder(3);
            }

            @Override
            public void cashPayment() {//现金支付
                mPresenter.createOrder(1);
            }

            @Override
            public void mobilePayment() {//移动支付
                mPresenter.createOrder(2);
            }
        });
    }

    /**
     * 显示提示msg
     *
     * @param type
     */
    @Override
    public void showMsg(int type) {
        switch (type) {
            case 1://挂单成功
                showToast(getResources().getString(R.string.put_order_success));
                break;
            case 2://下单成功
                showToast(getResources().getString(R.string.create_order_success));
                break;
            case 3:
                showToast("实收金额小于应付金额");
                break;

        }
    }

    /**
     * 显示商品快捷栏
     */
    @Override
    public void showShortcutBarFragment(ShortcutBarFragment barFragment) {
        showFragment(R.id.bar_content, barFragment);
    }

    /**
     * 显示计重栏
     */
    @Override
    public void showWeightBarFragment(WeightBarFragment barFragment) {
        showFragment(R.id.bar_content, barFragment);
    }

    /**
     * 设置商品栏变化
     *
     * @param position
     */
    @Override
    public void setGoodBarColor(int position) {
        switch (position) {
            case 0:
                tvShortcutBar.setTextColor(getResources().getColor(R.color.color_f5260b));
                tvWeightBar.setTextColor(getResources().getColor(R.color.color_000000));
                break;
            case 1:
                tvWeightBar.setTextColor(getResources().getColor(R.color.color_f5260b));
                tvShortcutBar.setTextColor(getResources().getColor(R.color.color_000000));
                break;
        }
    }

    /**
     * 获取商品栏的宽度
     */
    @Override
    public int getLayoutMidelWidth() {
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        layoutMidle.measure(w, h);
        int width = layoutMidle.getMeasuredWidth();
        return width;
    }

    /**
     * 显示取单
     */
    @Override
    public void showTakeOutOrder() {
        TakeOutOrderPopuWindow takeOutOrderPopuWindow = TakeOutOrderPopuWindow.getInstance(this);
        takeOutOrderPopuWindow.showAtLocation(findViewById(R.id.main_activity), Gravity.RIGHT, 0, 0);
    }

    /**
     * 登出
     */
    @Override
    public void outLogin() {
        ARouter.getInstance().build(RouteMap.ROUTE_LOGIN_ACTIVITY).navigation();
        finish();
    }

    /**
     * 显示当前时间
     */
    @Override
    public void showCurTime(String time) {
        tvCurTime.setText(time);
    }


    /**
     * 扫码枪条形码的拦截
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        mPresenter.scanAnalysisKeyEvent(event);
        return true;
    }

    /**
     * 扫码枪成功监听
     *
     * @param barcode
     */
    @Override
    public void onScanSuccess(String barcode) {
        LogUtils.e("barcode:  " + barcode);
        mPresenter.addSaleGoodsInfo(barcode);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvenBus(Map<Object, Object> map) {
        if (map.containsKey("updateManageType")) {//更新底部管理分类
            mPresenter.getBottomType();
        } else if (map.containsKey("addSaleGood")) {//添加销售商品
            String code = (String) map.get("addSaleGood");
            mPresenter.addSaleGoodsInfo(code);
        } else if (map.containsKey("takeOutOrderInfos")) {//取单
            OrderInfo orderInfos = (OrderInfo) map.get("takeOutOrderInfos");
            mPresenter.takeOutOrder(orderInfos);
        } else if (map.containsKey("loginOut")) {//登出
            mPresenter.outLogin();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }



}
