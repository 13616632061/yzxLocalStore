package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.presenter;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.yzx.lib.entity.MessageEvent;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.model.AddGoodsInfoActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.view.AddGoodsInfoActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/10.
 */

public class AddGoodsInfoActivityPresenter implements IAddGoodsInfoActivityPresenterImp {

    private AddGoodsInfoActivity mView;
    private AddGoodsInfoActivityModel mModel;

    public AddGoodsInfoActivityPresenter(AddGoodsInfoActivity mView) {
        this.mView = mView;
        mModel = new AddGoodsInfoActivityModel();
    }

    //商品分类
    @Override
    public void setGoodType() {
        List<GoodsType> spinnerItems = new ArrayList<>();
        for (GoodsType type : mModel.getGoodsTypeInfo()) {
            if (type.getStatus()) {
                spinnerItems.add(type);
            }
        }
        GoodsType goodsType = new GoodsType();
        goodsType.setTypeName(mView.getResources().getString(R.string.defaut_type));
        spinnerItems.add(0, goodsType);
        mView.setGoodType(spinnerItems);
    }


    //保存商品信息
    @Override
    public void saveGoodInfo() {
        if (TextUtils.isEmpty(mView.getGoodName())) {
            mView.errorMsg(0);
            return;
        }
        if (TextUtils.isEmpty(mView.getGoodCode())) {
            mView.errorMsg(1);
            return;
        }
        if (TextUtils.isEmpty(mView.getGoodPinyinCode())) {
            mView.errorMsg(2);
            return;
        }
        if (TextUtils.isEmpty(mView.getGoodStore())) {
            mView.errorMsg(3);
            return;
        }
        if (TextUtils.isEmpty(mView.getGoodStoreWarningNum())) {
            mView.errorMsg(4);
            return;
        }
        if (TextUtils.isEmpty(mView.getGoodOriginalPrice())) {
            mView.errorMsg(5);
            return;
        }
        if (TextUtils.isEmpty(mView.getGoodPrice())) {
            mView.errorMsg(6);
            return;
        }
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setTypeId(mView.getSelectGoodtype().getId());
        goodsInfo.setGoodsType(mView.getSelectGoodtype());
        goodsInfo.setGoodName(mView.getGoodName());
        goodsInfo.setGoodCode(mView.getGoodCode());
        goodsInfo.setGoodPinyinCode(mView.getGoodPinyinCode());
        goodsInfo.setGoodStore(Double.parseDouble(mView.getGoodStore()));
        goodsInfo.setGoodStoreWarningNum(Double.parseDouble(mView.getGoodStoreWarningNum()));
        goodsInfo.setGoodStatus(mView.getGoodStatus());
        goodsInfo.setGoodLoaction(mView.getGoodLoaction());
        goodsInfo.setGoodOriginalPrice(Double.parseDouble(mView.getGoodOriginalPrice()));
        goodsInfo.setGoodPrice(Double.parseDouble(mView.getGoodPrice()));
        goodsInfo.setGoodProfit(Double.parseDouble(ArithUtil.roundByScale(getGoodProfit(mView.getGoodPrice(), mView.getGoodOriginalPrice()), "#0.00")));
        goodsInfo.setVipLevelOnePrice(Double.parseDouble(setGoodVipLevelPrice(mView.getGoodVipLevelOnePrice())));
        goodsInfo.setVipLevelTwoPrice(Double.parseDouble(setGoodVipLevelPrice(mView.getGoodVipLevelTwoPrice())));
        goodsInfo.setVipLevelThreePrice(Double.parseDouble(setGoodVipLevelPrice(mView.getGoodVipLevelThreePrice())));
        goodsInfo.setVipLevelFourthPrice(Double.parseDouble(setGoodVipLevelPrice(mView.getGoodVipLevelFourthPrice())));
        goodsInfo.setVipLevelFivePrice(Double.parseDouble(setGoodVipLevelPrice(mView.getGoodVipLevelFivePrice())));

        mModel.addGoodsInfo(goodsInfo);
        EventBus.getDefault().post(new MessageEvent("addGoodsInfoSuccess", ""));
        mView.finish();
    }


    //商品上下架状态
    @Override
    public void setGoodStatus(int type, GoodsInfo goodsInfo) {
        switch (type) {
            case 1://新增
                mView.setGoodStatus(3);
                mView.setGoodLoaction(0);
                break;
            case 2://编辑
                if (goodsInfo.getGoodStatus()) {
                    mView.setGoodStatus(3);
                } else {
                    mView.setGoodStatus(4);
                }
                mView.setGoodLoaction(goodsInfo.getGoodLoaction());
                break;
        }
    }

    @Override
    public String setGoodVipLevelPrice(String vipLevelPrice) {
        if (TextUtils.isEmpty(vipLevelPrice)) {
            vipLevelPrice = 0 + "";
        }
        return vipLevelPrice;
    }

    //计算利润
    @Override
    public void setGoodProfit(String price, String originalPrice, int type) {
        String profit = getGoodProfit(price, originalPrice);
        mView.setGoodProfit(profit, type);

    }

    @Override
    public String getGoodProfit(String price, String originalPrice) {
        String profit = 0 + "";
        if (!TextUtils.isEmpty(originalPrice) && !TextUtils.isEmpty(price)) {
            //计算利润 （销售价-成本价）/成本价
            profit = ArithUtil.roundByScale(ArithUtil.div(ArithUtil.sub(price, originalPrice) + "", originalPrice) + "", "#0.00");
        }
        return profit;
    }

    //商品利润
    @Override
    public void countProfit(EditText view1, EditText view2, int type) {
        mView.countProfit(view1, view2, type);
    }

    //利润textView
    @Override
    public void setProfitTextView(TextView textView, String profit) {
        if (!TextUtils.isEmpty(profit)) {
            textView.setText(mView.getResources().getString(R.string.profit) + (Double.parseDouble(ArithUtil.roundByScale(profit, "#0.00")) * 100) + "%");
        } else {
            textView.setText("");
        }
    }

    //显示利润
    @Override
    public void showProfitInfo() {
        mView.showProfitInfo();
    }
}
