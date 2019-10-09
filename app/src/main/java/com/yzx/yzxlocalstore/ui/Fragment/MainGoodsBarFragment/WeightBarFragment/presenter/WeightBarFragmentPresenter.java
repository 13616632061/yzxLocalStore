package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.presenter;

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
    private List<GoodsType> mDataType=new ArrayList<>();
    private WeightBarFragmentTypeAdapter mTypeAdapter;

    private ShortcutBarFragmentAdapter mAdapter;
    private List<GoodsInfo> mData=new ArrayList<>();

    public WeightBarFragmentPresenter(WeightBarFragment mView) {
        this.mView = mView;
        mModel = new WeightBarFragmentModel();
    }

    /**
     * 初始化计重栏商品分类
     */
    @Override
    public void initWeightBarFragmentTypeAdapter() {
        mTypeAdapter=mView.initWeightBarFragmentTypeAdapter();
    }

    /**
     * 计重栏商品分类数据
     * @return
     */
    @Override
    public List<GoodsType> getDataType() {
        return mDataType;
    }

    /**
     *获取计重栏商品分类数据
     */
    @Override
    public void getWeightBarFragmentTypeData() {
        mDataType.clear();
        mDataType.addAll(mModel.getDataType());
        mTypeAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化计重栏商品
     */
    @Override
    public void initWeightBarFragmentAdapter() {
        mAdapter=mView.initWeightBarFragmentAdapter();
    }
    /**
     * 快捷商品数据
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
    public void getWeightBarData() {
        mData.clear();
        mData.addAll(mModel.getWeightBarData());
        mAdapter.notifyDataSetChanged();
    }
    /**
     * 获取快捷栏的宽度
     */
    @Override
    public int getLayoutWidth() {
        return mView.getArguments().getInt("width")*4/5;
    }
}
