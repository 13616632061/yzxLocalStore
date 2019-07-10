package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.presenter;

import android.text.TextUtils;

import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.model.AddGoodsInfoActivityModel;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.view.AddGoodsInfoActivity;

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
        List<GoodsType> spinnerItems = mModel.getGoodsTypeInfo();
        GoodsType goodsType = new GoodsType();
        goodsType.setTypeName(mView.getResources().getString(R.string.defaut_type));
        spinnerItems.add(0, goodsType);
        mView.setGoodType(spinnerItems);
    }

    @Override
    public void getSelectedGoodType(GoodsType goodsType) {
        mView.getGoodType(goodsType);
    }

    //保存商品信息
    @Override
    public void saveGoodInfo() {
        isEmptyInfo(mView.getGoodName(), 0);
        isEmptyInfo(mView.getGoodCode(), 1);
        isEmptyInfo(mView.getGoodPinyinCode(), 2);
        isEmptyInfo(mView.getGoodStore(), 3);
        isEmptyInfo(mView.getGoodStoreWarningNum(), 4);
        isEmptyInfo(mView.getGoodOriginalPrice(), 5);
        isEmptyInfo(mView.getGoodPrice(), 6);
        GoodsInfo goodsInfo = new GoodsInfo();
//        goodsInfo.setGoodsType();
        goodsInfo.setGoodName(mView.getGoodName());
        goodsInfo.setGoodCode(mView.getGoodCode());
        goodsInfo.setGoodPinyinCode(mView.getGoodPinyinCode());
        goodsInfo.setGoodStore(Double.parseDouble(mView.getGoodStore()));
        goodsInfo.setGoodStoreWarningNum(Double.parseDouble(mView.getGoodStoreWarningNum()));
    }

    //空信息
    @Override
    public void isEmptyInfo(String info, int type) {
        if (TextUtils.isEmpty(info)) {
            mView.errorMsg(type);
            return;
        }
    }
}
