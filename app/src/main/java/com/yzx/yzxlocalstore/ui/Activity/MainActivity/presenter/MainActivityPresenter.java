package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.blankj.utilcode.util.Utils;
import com.yzx.lib.util.ArithUtil;
import com.yzx.lib.util.ScanGunKeyEventHelper;
import com.yzx.lib.util.TimeUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.OrderInfo;
import com.yzx.yzxlocalstore.entity.SaleGoodsInfo;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.entity.User;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.MainToAction.MainToAction;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.model.MainActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.MainActivity;
import com.yzx.yzxlocalstore.ui.Adapter.MainLeftSaleGoodsListAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view.GoodsListFragment;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view.GoodsTypeFragment;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.view.ShortcutBarFragment;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.view.WeightBarFragment;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2019/6/28.
 */

public class MainActivityPresenter implements IMainActivityPresenterImp {

    private static String TAG = MainActivityPresenter.class.getClass().getSimpleName();
    private MainActivity mView;
    private MainActivityModel mModel;
    private List<SaleGoodsInfo> saleGoodsInfoData = new ArrayList<>();
    private MainLeftSaleGoodsListAdapter mainLeftSaleGoodsListAdapter;//左边商品销售列表
    private ScanGunKeyEventHelper mScanGunKeyEventHelper;//扫码枪工具类


    public MainActivityPresenter(MainActivity mView) {
        this.mView = mView;
        mModel = new MainActivityModel();
        mScanGunKeyEventHelper = new ScanGunKeyEventHelper(mView);
    }

    /**
     * 初始化管理栏目
     */
    @Override
    public void initTypeChannel() {
        String[] typNameList = new String[]{
                mView.getResources().getString(R.string.moreType),
                mView.getResources().getString(R.string.putOrder),
                mView.getResources().getString(R.string.loginOut),
                mView.getResources().getString(R.string.changeShifts),
                mView.getResources().getString(R.string.cashBox),
                mView.getResources().getString(R.string.lockScreen),
                mView.getResources().getString(R.string.print),
                mView.getResources().getString(R.string.getOrder),
                mView.getResources().getString(R.string.rejectedGood),
                mView.getResources().getString(R.string.cashPrize),
                mView.getResources().getString(R.string.changeMoney),
                mView.getResources().getString(R.string.onCredit),
                mView.getResources().getString(R.string.retail),
                mView.getResources().getString(R.string.takeOutFood),
                mView.getResources().getString(R.string.detele),
                mView.getResources().getString(R.string.goodsManage),
                mView.getResources().getString(R.string.staffManage),
                mView.getResources().getString(R.string.orderManage),
                mView.getResources().getString(R.string.reportForm),
                mView.getResources().getString(R.string.inventory),
                mView.getResources().getString(R.string.vip),
                mView.getResources().getString(R.string.set)
        };
        if (mModel.isInitTypeChannel(typNameList.length)) {
            return;
        }
        List<TypeBean> typeBeanList = new ArrayList<>();
        for (String typeName : typNameList) {
            TypeBean typeBean = new TypeBean();
            typeBean.setId(LoginUserUtil.getInstance().getLoginUser().getId());
            typeBean.setName(typeName);
            if (typeName.equals(mView.getResources().getString(R.string.moreType))) {
                typeBean.setTypeCode(1);
            }
            typeBeanList.add(typeBean);
        }
        for (TypeBean bean : typeBeanList) {
            mModel.initTypeChannel(bean);
        }
    }

    //显示更多分类信息
    @Override
    public void showMoreTypeChannel() {
        mView.showMoreTypeChannel();
    }

    /**
     * 获取底部管理分类
     */
    @Override
    public void getBottomType() {
        mView.mBottomTypeData().clear();
        mView.mBottomTypeData().addAll(mModel.getBottomType());
        mView.mainBottomTypeAdapter().notifyDataSetChanged();
    }

    /**
     * 设置底部管理分类的视图
     */
    @Override
    public void setBottomTypeView() {
        mView.setBottomTypeView();
    }

    /**
     * 底部管理分类点击事件
     *
     * @param name
     */
    @Override
    public void setBottomTypeOnClick(String name) {
        if (mView.getResources().getString(R.string.moreType).equals(name)) {//更多
            mView.showMoreTypeChannel();
        } else if (mView.getResources().getString(R.string.detele).equals(name)) {//删除
            removeSelectSaleGoodsInfoItem();
        } else if (mView.getResources().getString(R.string.retail).equals(name)) {
            addSaleGoodsInfo("123456");
        } else if (mView.getResources().getString(R.string.putOrder).equals(name)) {//挂单
            createOrder(0);
        } else {
            MainToAction.toAction(mView, name);
        }
    }

    /**
     * 初始化左边销售商品信息
     */
    @Override
    public void setLeftSaleGoodsListView() {
        mainLeftSaleGoodsListAdapter = mView.setLeftSaleGoodsListView();
    }

    /**
     * 销售商品信息数据
     *
     * @return
     */
    @Override
    public List<SaleGoodsInfo> saleGoodsInfoData() {
        return saleGoodsInfoData;
    }

    /**
     * 设置选中的销售商品信息item
     */
    @Override
    public void setSelectSaleGoodsInfoItem(int position) {
        for (int i = 0; i < saleGoodsInfoData.size(); i++) {
            saleGoodsInfoData.get(i).setSelectItem(false);
        }
        saleGoodsInfoData.get(position).setSelectItem(true);
        mainLeftSaleGoodsListAdapter.notifyDataSetChanged();
    }

    /**
     * 添加销售商品
     */
    @Override
    public void addSaleGoodsInfo(String code) {
        List<GoodsInfo> list = mModel.fromCodeQureGoodsinfo(code);
        if (list.size() > 0) {
            SaleGoodsInfo saleGoodsInfo = new SaleGoodsInfo();
            saleGoodsInfo.setGoodsInfo(list.get(0));
            saleGoodsInfo.setNum(1);
            saleGoodsInfo.setSubtotalPrice(list.get(0).getGoodPrice() * 1);
            boolean isExit=false;
            for (int i=0;i<saleGoodsInfoData.size();i++){
                if (saleGoodsInfoData.get(i).getGoodsInfo().getId()==saleGoodsInfo.getGoodsInfo().getId()){
                    double num=saleGoodsInfoData.get(i).getNum();
                    saleGoodsInfoData.get(i).setNum(num+1);
                    mView.LeftSaleGoodsListScrollToPosition(i);
                    setSelectSaleGoodsInfoItem(i);
                    isExit=true;
                }
            }
            if (!isExit){
                saleGoodsInfoData.add(saleGoodsInfo);
                mView.LeftSaleGoodsListScrollToPosition(saleGoodsInfoData.size() - 1);
                setSelectSaleGoodsInfoItem(saleGoodsInfoData.size() - 1);
            }
            mainLeftSaleGoodsListAdapter.notifyDataSetChanged();

            setTotalGoodNum();
            setTotalPrice();
            setReceivableMoney();
            mView.setChangeMoney();

        } else {
            Toast.makeText(mView, "没有此商品", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 删除选中的item
     */
    @Override
    public void removeSelectSaleGoodsInfoItem() {
        for (int i = 0; i < saleGoodsInfoData.size(); i++) {
            if (saleGoodsInfoData.get(i).isSelectItem()) {
                saleGoodsInfoData.remove(i);
                break;
            }
        }
        if (saleGoodsInfoData.size() > 0) {
            mView.LeftSaleGoodsListScrollToPosition(saleGoodsInfoData.size() - 1);
            setSelectSaleGoodsInfoItem(saleGoodsInfoData.size() - 1);
        }
        mainLeftSaleGoodsListAdapter.notifyDataSetChanged();
        setTotalGoodNum();
        setTotalPrice();
        setReceivableMoney();
        mView.setChangeMoney();
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
    public double setTotalGoodNum() {
        double totalNum = 0;
        for (SaleGoodsInfo saleGoodsInfo : saleGoodsInfoData) {
            totalNum += saleGoodsInfo.getNum();
        }
        mView.setTotalGoodNum(totalNum + "");

        return totalNum;
    }

    /**
     * 销售商品的总价格
     */
    @Override
    public void setTotalPrice() {
        double totalPrice = 0;
        for (SaleGoodsInfo saleGoodsInfo : saleGoodsInfoData) {
            totalPrice += saleGoodsInfo.getSubtotalPrice()*saleGoodsInfo.getNum();
        }
        mView.setTotalPrice(ArithUtil.roundByScale(totalPrice + "", "#0.00"));
    }

    /**
     * 应收金额
     */
    @Override
    public double setReceivableMoney() {
        double totalPrice = 0;
        for (SaleGoodsInfo saleGoodsInfo : saleGoodsInfoData) {
            totalPrice += saleGoodsInfo.getSubtotalPrice()*saleGoodsInfo.getNum();
        }
        mView.setReceivableMoney(ArithUtil.roundByScale(totalPrice + "", "#0.00"));
        return totalPrice;
    }

    /**
     * 创建订单
     *
     * @param type
     */
    @Override
    public void createOrder(int type) {
        if (saleGoodsInfoData.size() <= 0) {
            return;
        }
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(getOrderId());
        List<GoodsInfo> goodsInfos = new ArrayList<>();

        for (SaleGoodsInfo bean : saleGoodsInfoData) {
            goodsInfos.add(bean.getGoodsInfo());
        }
        orderInfo.setGoodsInfos(goodsInfos);
        orderInfo.setOrderCreatPerson(LoginUserUtil.getInstance().getLoginUser());
        orderInfo.setGoodTotalNum(setTotalGoodNum());
        orderInfo.setTotalMoney(setReceivableMoney());
        orderInfo.setOrderProfit(getOrderProfit());
        orderInfo.setOrderCreatTime(TimeUtils.getNowMills());
        switch (type) {
            case 0://挂单  正常订单:0,挂单:1,作废订单:2
                orderInfo.setOrderType(1);
                break;
            case 1://现金支付：1，移动支付：2，会员支付：3，
                if (mView.getChangeMoney() < 0) {
                    mView.showMsg(3);
                    return;
                }
                orderInfo.setOrderPayType(1);
                break;
            case 2://移动支付
                orderInfo.setOrderPayType(2);
                break;
            case 3://会员支付
                orderInfo.setOrderPayType(3);
                break;
        }
        mModel.createOrder(orderInfo);
        saleGoodsInfoData.clear();
        mainLeftSaleGoodsListAdapter.notifyDataSetChanged();

        switch (type) {
            case 0:
                mView.showMsg(1);
                break;
            default:
                mView.showMsg(2);
                break;
        }
    }

    /**
     * 获取订单id
     *
     * @return
     */
    @Override
    public String getOrderId() {
        Random rand = new Random();
        int randNum = rand.nextInt(1000000);
        String orderId = TimeUtils.getNowMills() + randNum + "";
        Log.e("TAG", "orderId: " + orderId);
        return orderId;
    }

    /**
     * 获取订单利润
     *
     * @return
     */
    @Override
    public double getOrderProfit() {
        double orderProfit = 0;
        for (SaleGoodsInfo saleGoodsInfo : saleGoodsInfoData) {
            orderProfit += saleGoodsInfo.getGoodsInfo().getGoodProfit();
        }
        if (saleGoodsInfoData.size() > 0) {
            orderProfit = ArithUtil.div(orderProfit + "", saleGoodsInfoData.size() + "");
        }
        return orderProfit;
    }

    /**
     * 选择支付方式
     */
    @Override
    public void selcetPayment() {
        mView.selcetPayment();
    }

    /**
     * 扫码枪事件解析
     */
    @Override
    public void scanAnalysisKeyEvent(KeyEvent event) {
        mScanGunKeyEventHelper.analysisKeyEvent(event);
    }

    /**
     * 显示商品快捷栏，计重栏
     */
    @Override
    public void showGoodBarPosition(int position) {
        Bundle bundle=new Bundle();
        bundle.putInt("width",mView.getLayoutMidelWidth());
        switch (position) {
            case 0:
                ShortcutBarFragment barFragment=new ShortcutBarFragment();
                barFragment.setArguments(bundle);
                mView.showShortcutBarFragment(barFragment);
                break;
            case 1:
                WeightBarFragment weightBarFragment=new WeightBarFragment();
                weightBarFragment.setArguments(bundle);
                mView.showWeightBarFragment(weightBarFragment);
                break;
        }
        mView.setGoodBarColor(position);
    }


}
