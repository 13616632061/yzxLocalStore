package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.presenter;

import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Adapter.ShortcutBarFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Adapter.WeightBarFragmentTypeAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.model.WeightBarFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.view.WeightBarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class WeightBarFragmentPresenter implements IWeightBarFragmentPresenterImp {


    private WeightBarFragment mView;
    private WeightBarFragmentModel mModel;
    private List<GoodsType> mDataType = new ArrayList<>();
    private WeightBarFragmentTypeAdapter mTypeAdapter;

    private ShortcutBarFragmentAdapter mAdapter;
    private List<GoodsInfo> mData = new ArrayList<>();

    public WeightBarFragmentPresenter(WeightBarFragment mView) {
        this.mView = mView;
        mModel = new WeightBarFragmentModel();
    }

    /**
     * 初始化计重栏商品分类
     */
    @Override
    public void initWeightBarFragmentTypeAdapter() {
        mTypeAdapter = mView.initWeightBarFragmentTypeAdapter();
    }

    /**
     * 计重栏商品分类数据
     *
     * @return
     */
    @Override
    public List<GoodsType> getDataType() {
        return mDataType;
    }

    /**
     * 获取计重栏商品分类数据
     */
    @Override
    public void getWeightBarFragmentTypeData(int type, int position) {
        mDataType.clear();
        GoodsType allType=new GoodsType();
        allType.setIsSelect(true);
        allType.setTypeName(mView.getResources().getString(R.string.alls));
        allType.setStatus(true);
        mDataType.add(allType);
        mDataType.addAll(mModel.getDataType());
        mTypeAdapter.notifyDataSetChanged();
        if (mDataType.size() > 0) {
            getWeightBarData(type, mDataType.get(position).getTypeName());
        }
    }

    /**
     * 计重栏商品分类点击事件
     *
     * @param position
     */
    @Override
    public void setWeightBarFragmentTypeListener(int type,int position) {
        getWeightBarData(type,mDataType.get(position).getTypeName());
        for (int i = 0; i < mDataType.size(); i++) {
            mDataType.get(i).setIsSelect(false);
        }
        mDataType.get(position).setIsSelect(true);
        mTypeAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化计重栏商品
     */
    @Override
    public void initWeightBarFragmentAdapter() {
        mAdapter = mView.initWeightBarFragmentAdapter();
    }

    /**
     * 快捷商品数据
     *
     * @return
     */
    @Override
    public List<GoodsInfo> getData() {
        return mData;
    }

    /**
     * 获取快捷商品数据
     */
    @Override
    public void getWeightBarData(int type, String typeName) {
        mData.clear();
        switch (type) {
            case 0://全部商品
                mData.addAll(mModel.getAllWeightBarData());
                break;
            case 1://单个分类商品
                mData.addAll(mModel.getWeightBarData(typeName));
                break;
        }
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 获取快捷栏的宽度
     */
    @Override
    public int getLayoutWidth() {
        return mView.getArguments().getInt("width") * 4 / 5;
    }
}
