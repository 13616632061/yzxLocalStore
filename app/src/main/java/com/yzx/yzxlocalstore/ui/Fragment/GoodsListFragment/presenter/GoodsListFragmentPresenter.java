package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter;

import android.nfc.tech.NfcV;
import android.os.AsyncTask;

import com.apkfuns.logutils.LogUtils;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.model.GoodsListFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view.GoodsListFragment;
import com.yzx.yzxlocalstore.utils.AsyncTaskQureUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public class GoodsListFragmentPresenter implements IGoodsListFragmentPresenterImp {

    private GoodsListFragment mView;
    private GoodsListFragmentModel mModel;

    public GoodsListFragmentPresenter(GoodsListFragment mView) {
        this.mView = mView;
        mModel = new GoodsListFragmentModel();
    }

    @Override
    public void initAdapter() {
        mView.initAdapter();
    }

    /**
     * 查询商品
     *
     * @param page 页数
     * @param type 商品类型 0全部商品，1缺货商品,2库存预警
     * @return
     */
    @Override
    public void getGoodsInfo(int page, int type) {
        List<GoodsInfo> goodsInfoList = mModel.getGoodsInfo(page, type);
        mView.getData().clear();
        mView.getData().addAll(goodsInfoList);
        mView.getAdapter().notifyDataSetChanged();
        switch (type) {
            case 0://全部商品
                setAllGoodsNum();
                isSelectAllGoodsType(true);
                isSelectLackGoodsType(false);
                isSelectWarningGoodsType(false);
                break;
            case 1://缺货商品,
                setLackGoodsInfom();
                isSelectAllGoodsType(false);
                isSelectLackGoodsType(true);
                isSelectWarningGoodsType(false);
                break;
            case 2://库存预警
                setWarningGoodsNum();
                isSelectAllGoodsType(false);
                isSelectLackGoodsType(false);
                isSelectWarningGoodsType(true);
                break;
        }
    }

    /**
     * 商品选中状态
     *
     * @param type     0全选，1单个选中
     * @param position
     */
    @Override
    public void editGoodsInfoSelectStatus(int type, int position) {
        switch (type) {
            case 0://全选
                if (mView.isAllSelect()) {
                    mView.setAllSelect(false);
                    for (int i = 0; i < mView.getData().size(); i++) {
                        mView.getData().get(i).setIsSelect(false);
                    }
                } else {
                    mView.setAllSelect(true);
                    for (int i = 0; i < mView.getData().size(); i++) {
                        mView.getData().get(i).setIsSelect(true);
                    }
                }
                mView.showAllSelectStatus();
                mView.getAdapter().notifyDataSetChanged();
                break;
            case 1://单个选中
                if (mView.getData().get(position).getIsSelect()) {
                    mView.getData().get(position).setIsSelect(false);
                } else {
                    mView.getData().get(position).setIsSelect(true);
                }
                mView.setAllSelect(isAllSelect());
                mView.showAllSelectStatus();
                mView.getAdapter().notifyDataSetChanged();
                break;

        }
    }

    /**
     * 是否全部选中
     *
     * @return
     */
    @Override
    public boolean isAllSelect() {
        boolean isAllSelect = true;
        if (mView.getData().size() <= 0) {
            isAllSelect = false;
        }
        for (int i = 0; i < mView.getData().size(); i++) {
            if (!mView.getData().get(i).getIsSelect()) {
                isAllSelect = false;
                break;
            }
        }
        return isAllSelect;
    }

    /**
     * 所有商品数量
     */
    @Override
    public void setAllGoodsNum() {
        mView.setAllGoodsNum(mModel.getAllGoodsNum());
    }

    /**
     * 缺货商品数量
     */
    @Override
    public void setLackGoodsInfom() {
        mView.setLackGoodsInfom(mModel.getLackGoodsInfom());
    }

    /**
     * 库存预警商品数量
     */
    @Override
    public void setWarningGoodsNum() {
        mView.setWarningGoodsNum(mModel.getWarningGoodsNum());
    }

    /**
     * 是否选中所有商品类型
     *
     * @param isSelectAllGoods
     */
    @Override
    public void isSelectAllGoodsType(boolean isSelectAllGoods) {
        mView.isSelectAllGoodsType(isSelectAllGoods);
    }

    /**
     * 是否选中缺货商品类型
     *
     * @param iisSelectLackGoods
     */
    @Override
    public void isSelectLackGoodsType(boolean iisSelectLackGoods) {
        mView.isSelectLackGoodsType(iisSelectLackGoods);
    }

    /**
     * 是否选中库存预警商品类型
     *
     * @param isSelectWarningGoods
     */
    @Override
    public void isSelectWarningGoodsType(boolean isSelectWarningGoods) {
        mView.isSelectWarningGoodsType(isSelectWarningGoods);
    }

    @Override
    public void lackGoodsInfo() {

    }

    @Override
    public void warningGoodsInfo() {

    }

    //添加商品
    @Override
    public void addGoodsInfo() {
        mView.addGoodsInfo();
    }

    /**
     * 删除商品
     */
    @Override
    public void deteleGoodsInfo() {
        if (getSelectGoodsInfo().size() > 0) {
            mModel.deteleGoodsInfo(getSelectGoodsInfo());
            EventBus.getDefault().post(new MessageEvent("addGoodsInfoSuccess", ""));
        }
    }

    /**
     * 显示操作提示框
     */
    @Override
    public void showHandleGoodsInfoTipMsg(int type) {
        switch (type) {
            case 1://删除商品
                if (isExistSelectGoodsInfo()) {
                    mView.deteleGoodsInfo();
                } else {
                    mView.showErrorMsg(1);
                }
                break;
            case 2://上架商品
                if (isExistSelectGoodsInfo()) {
                    mView.upShelfGoodsInfo();
                } else {
                    mView.showErrorMsg(2);
                }
                break;
            case 3://下架商品
                if (isExistSelectGoodsInfo()) {
                    mView.dowmShelfGoodsInfo();
                } else {
                    mView.showErrorMsg(3);
                }
                break;
        }
    }

    /**
     * 获取选中商品信息
     *
     * @return
     */
    @Override
    public List<GoodsInfo> getSelectGoodsInfo() {
        List<GoodsInfo> goodsInfoList = new ArrayList<>();
        for (GoodsInfo goodsInfo : mView.getData()) {
            if (goodsInfo.getIsSelect()) {
                goodsInfoList.add(goodsInfo);
            }
        }
        return goodsInfoList;
    }

    /**
     * 是否存在选中商品
     *
     * @return
     */
    @Override
    public boolean isExistSelectGoodsInfo() {
        boolean isExistSelectGoodsInfo = false;
        for (GoodsInfo goodsInfo : mView.getData()) {
            if (goodsInfo.getIsSelect()) {
                isExistSelectGoodsInfo = true;
                break;
            }
        }
        return isExistSelectGoodsInfo;
    }

    /**
     * 上架商品
     */
    @Override
    public void upShelfGoodsInfo() {
        if (getSelectGoodsInfo().size() > 0) {
            List<GoodsInfo> goodsInfoList = new ArrayList<>();
            for (GoodsInfo goodsInfo : getSelectGoodsInfo()) {
                goodsInfo.setGoodStatus(true);
                goodsInfoList.add(goodsInfo);
            }
            mModel.editGoodsInfo(goodsInfoList);
            EventBus.getDefault().post(new MessageEvent("addGoodsInfoSuccess", ""));

        }

    }

    /**
     * 下架商品
     */
    @Override
    public void dowmShelfGoodsInfo() {
        if (getSelectGoodsInfo().size() > 0) {
            List<GoodsInfo> goodsInfoList = new ArrayList<>();
            for (GoodsInfo goodsInfo : getSelectGoodsInfo()) {
                goodsInfo.setGoodStatus(false);
                goodsInfoList.add(goodsInfo);
            }
            mModel.editGoodsInfo(goodsInfoList);
            EventBus.getDefault().post(new MessageEvent("addGoodsInfoSuccess", ""));

        }
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
     * 编辑商品
     *
     * @param goodInfo
     */
    @Override
    public void goToEditGoodsInfo(GoodsInfo goodInfo) {
        mView.goToEditGoodsInfo(goodInfo);
    }
}
