package com.yzx.yzxlocalstore.ui.Activity.MainActivity.presenter;

import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.LogUtils;
import com.cheng.channel.Channel;
import com.google.gson.Gson;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.ManageChannelType;
import com.yzx.yzxlocalstore.entity.ManageType;
import com.yzx.yzxlocalstore.entity.SaleGoodsInfo;
import com.yzx.yzxlocalstore.entity.TypeBean;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.MainToAction.MainToAction;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.model.MainActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.MainActivity.view.MainActivity;
import com.yzx.yzxlocalstore.utils.LoginUserUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/6/28.
 */

public class MainActivityPresenter implements IMainActivityPresenterImp {

    private MainActivity mView;
    private MainActivityModel mModel;
    private List<SaleGoodsInfo> saleGoodsInfoData = new ArrayList<>();


    public MainActivityPresenter(MainActivity mView) {
        this.mView = mView;
        mModel = new MainActivityModel();
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
            addSaleGoodsInfo();
        } else {
            MainToAction.toAction(mView, name);
        }
    }

    /**
     * 初始化左边销售商品信息
     */
    @Override
    public void setLeftSaleGoodsListView() {
        mView.setLeftSaleGoodsListView();
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
        mView.mainLeftSaleGoodsListAdapter().notifyDataSetChanged();
    }

    /**
     * 添加销售商品
     */
    @Override
    public void addSaleGoodsInfo() {
        List<GoodsInfo> list = mModel.fromCodeQureGoodsinfo("123456");
        if (list.size() > 0) {
            SaleGoodsInfo saleGoodsInfo = new SaleGoodsInfo();
            saleGoodsInfo.setGoodsInfo(list.get(0));
            saleGoodsInfo.setNum(1);
            saleGoodsInfo.setSubtotalPrice(list.get(0).getGoodPrice() * 1);
            saleGoodsInfoData.add(saleGoodsInfo);
            mView.LeftSaleGoodsListScrollToPosition();
            setSelectSaleGoodsInfoItem(saleGoodsInfoData.size() - 1);
            mView.mainLeftSaleGoodsListAdapter().notifyDataSetChanged();

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
            mView.LeftSaleGoodsListScrollToPosition();
            setSelectSaleGoodsInfoItem(saleGoodsInfoData.size() - 1);
        }
        mView.mainLeftSaleGoodsListAdapter().notifyDataSetChanged();
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
    public void setTotalGoodNum() {
        double totalNum = 0;
        for (SaleGoodsInfo saleGoodsInfo : saleGoodsInfoData) {
            totalNum += saleGoodsInfo.getNum();
        }
        mView.setTotalGoodNum(totalNum + "");
    }

    /**
     * 销售商品的总价格
     */
    @Override
    public void setTotalPrice() {
        double totalPrice = 0;
        for (SaleGoodsInfo saleGoodsInfo : saleGoodsInfoData) {
            totalPrice += saleGoodsInfo.getSubtotalPrice();
        }
        mView.setTotalPrice(ArithUtil.roundByScale(totalPrice + "", "#0.00"));
    }

    /**
     * 应收金额
     */
    @Override
    public void setReceivableMoney() {
        double totalPrice = 0;
        for (SaleGoodsInfo saleGoodsInfo : saleGoodsInfoData) {
            totalPrice += saleGoodsInfo.getSubtotalPrice();
        }
        mView.setReceivableMoney(ArithUtil.roundByScale(totalPrice + "", "#0.00"));
    }

}
