package com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.presenter;

import android.content.res.TypedArray;
import android.nfc.tech.NfcV;
import android.os.AsyncTask;
import android.text.TextUtils;

import com.apkfuns.logutils.LogUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.model.GoodsListFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsListFragment.view.GoodsListFragment;
import com.yzx.yzxlocalstore.utils.AsyncTaskQureUtils;
import com.yzx.yzxlocalstore.utils.ExcelUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/9.
 */

public class GoodsListFragmentPresenter implements IGoodsListFragmentPresenterImp {

    private GoodsListFragment mView;
    private GoodsListFragmentModel mModel;
    private int mType;
    private long mPage = 1;
    private int mLimitPageNum = 20;

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
    public void getGoodsInfo(long page, int type) {
        mType = type;
        mPage = page;
        List<GoodsInfo> goodsInfoList = mModel.getGoodsInfo((int) page, type);
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
        setCurRecord();
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
        mView.setAllGoodsNum(mModel.getAllGoodsNum(mType) + "");
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
    public void selectimportGoodsInfoFile() {
        new LFilePicker()
                .withSupportFragment(mView)
                .withRequestCode(100)
                .withStartPath("/storage/emulated/0/Download")//指定初始显示路径
                .withTitle("选择导入的文件")
                .withMaxNum(1)
                .withMutilyMode(true)
                .withNotFoundBooks("至少选择一个文件")
                .withFileFilter(new String[]{".xls"})
                .start();
    }

    /**
     * 导入商品
     */
    @Override
    public void importGoodsInfo(final String path) {
        new AsyncTaskQureUtils(new AsyncTaskQureUtils.preBefore() {
            @Override
            public void before() {

            }
        }, new AsyncTaskQureUtils.QureData() {
            @Override
            public Object qureData() {
                return ExcelUtil.ImportExcelData(path);
            }
        }, new AsyncTaskQureUtils.Success() {
            @Override
            public void Success(Object object) {
                List<GoodsInfo> infoList = new Gson().fromJson((String) object, new TypeToken<List<GoodsInfo>>() {
                }.getType());
                if (infoList != null && infoList.size() > 0) {
                    for (GoodsInfo goodsInfo : infoList) {
                        mModel.addGoodsInfo(goodsInfo);
                    }
                    getGoodsInfo(1, 0);
                }
            }
        }).execute();
    }

    @Override
    public void searchGoodsInfo() {
        String content = mView.getEtSearchContent();
        if (TextUtils.isEmpty(content)) {
            mView.showErrorMsg(4);
            return;
        }
        List<GoodsInfo> list = mModel.qureyGoodsInfo(content);
        mView.getData().clear();
        mView.getData().addAll(list);
        mView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void exportGoodsInfo() {

    }

    @Override
    public void printLabel() {

    }

    /**
     * 首页
     */
    @Override
    public void firstPage() {
        mPage = 1;
        getGoodsInfo(mPage, mType);
    }

    /**
     * 尾页
     */
    @Override
    public void lastPage() {
        mPage = getlastPageNum();
        getGoodsInfo(mPage, mType);
    }

    /**
     * 上一页
     */
    @Override
    public void previousPage() {
        if (mPage > 1) {
            mPage--;
        }
        getGoodsInfo(mPage, mType);
    }

    /**
     * 下一页
     */
    @Override
    public void nextPage() {
        if (mPage < getlastPageNum()) {
            mPage++;
        }
        getGoodsInfo(mPage, mType);
    }

    /**
     * 获取最后一页的页码
     */
    @Override
    public long getlastPageNum() {
        long count = mModel.getAllGoodsNum(mType) / mLimitPageNum;
        if (mModel.getAllGoodsNum(mType) % mLimitPageNum > 0) {
            count++;
        }
        if (count == 0) {
            count = 1;
        }
        return count;
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

    /**
     * 每页最多显示多少条
     */
    @Override
    public void setMaxShowPage() {
        mView.setMaxShowPage(mLimitPageNum + "");
    }

    /**
     * 当前记录
     */
    @Override
    public void setCurRecord() {
        mView.setCurRecord(mModel.getAllGoodsNum(mType), mPage, ((mPage - 1) * mLimitPageNum) + 1, mPage * mLimitPageNum);
    }
}
