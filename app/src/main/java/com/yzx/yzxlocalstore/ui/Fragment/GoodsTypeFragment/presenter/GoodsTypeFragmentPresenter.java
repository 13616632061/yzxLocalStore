package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.presenter;

import android.widget.Toast;

import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.model.GoodsTypeFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view.GoodsTypeFragment;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypeFragmentPresenter implements IGoodsTypeFragmentPresenterImp {
    private GoodsTypeFragment mView;
    private GoodsTypeFragmentModel mModel;

    public GoodsTypeFragmentPresenter(GoodsTypeFragment mView) {
        this.mView = mView;
        mModel = new GoodsTypeFragmentModel();
    }

    @Override
    public void initAdapter() {
        mView.initAdapter();
    }

    @Override
    public void getGoodsTypeInfo() {
        List<GoodsType> list = mModel.getGoodsTypeInfo(mView.getActivity());
        Collections.sort(list);
        mView.getGoodsTypeDatas().clear();
        mView.getGoodsTypeDatas().addAll(list);
        mView.getAdapter().notifyDataSetChanged();
        mView.setGoodsTypeNum(list.size());
    }

    @Override
    public void showGoodsTypePopWindow(int type,GoodsType goodsType) {
        switch (type) {
            case 1://添加
                mView.addGoodsType();
                break;
            case 2://编辑
                mView.editGoodsType(goodsType);
                break;
        }
    }

    @Override
    public void addGoodsType(String typeName, String sort) {
        if (!mModel.isHasGoodsType(mView.getActivity(), typeName)) {
            GoodsType goodsType = new GoodsType();
            goodsType.setTypeName(typeName);
            goodsType.setSort(Integer.parseInt(sort));
            mModel.addGoodsType(goodsType);
            getGoodsTypeInfo();
        } else {
            Toast.makeText(mView.getActivity(), mView.getResources().getString(R.string.goods_type_name_exist), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void deleteGoodsType() {

    }

    @Override
    public void editGoodsType(GoodsType goodsType) {
        mModel.editGoodsType(goodsType);
        getGoodsTypeInfo();
    }

    @Override
    public void editGoodsTypeSelectStatus(int type, int position) {
        if (type == 1) {//单个选中
            if (mView.getGoodsTypeDatas().get(position).getIsSelect()) {
                mView.getGoodsTypeDatas().get(position).setIsSelect(false);
            } else {
                mView.getGoodsTypeDatas().get(position).setIsSelect(true);
            }
            //判断是否全部选中
            boolean isAllSelect = true;
            for (int i = 0; i < mView.getGoodsTypeDatas().size(); i++) {
                if (!mView.getGoodsTypeDatas().get(i).getIsSelect()) {
                    isAllSelect = false;
                    break;
                }
            }
            mView.setAllSelect(isAllSelect);
        } else {//全选
            if (mView.isAllSelect()) {
                mView.setAllSelect(false);
                for (int i = 0; i < mView.getGoodsTypeDatas().size(); i++) {
                    mView.getGoodsTypeDatas().get(i).setIsSelect(false);
                }
            } else {
                mView.setAllSelect(true);
                for (int i = 0; i < mView.getGoodsTypeDatas().size(); i++) {
                    mView.getGoodsTypeDatas().get(i).setIsSelect(true);
                }
            }
        }
        mView.allSelect();
        mView.getAdapter().notifyDataSetChanged();
    }

    //商品分类启用状态
    @Override
    public void setGoodsTypeEnableStatus(int position, boolean enable) {
        mView.getGoodsTypeDatas().get(position).setStatus(enable);
    }
}
