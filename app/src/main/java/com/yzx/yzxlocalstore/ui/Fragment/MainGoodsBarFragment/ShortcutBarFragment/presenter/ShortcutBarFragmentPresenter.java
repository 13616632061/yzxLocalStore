package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.presenter;

import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.ui.Adapter.ShortcutBarFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.model.ShortcutBarFragmentModel;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.view.ShortcutBarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/10/9.
 */

public class ShortcutBarFragmentPresenter implements IShortcutBarFragmentPresenterImp{

    private ShortcutBarFragment mView;
    private ShortcutBarFragmentModel mModel;
    private ShortcutBarFragmentAdapter mAdapter;
    private List<GoodsInfo> mData=new ArrayList<>();

    public ShortcutBarFragmentPresenter(ShortcutBarFragment mView) {
        this.mView = mView;
        mModel=new ShortcutBarFragmentModel();
    }

    /**
     * 初始化快捷商品适配器
     */
    @Override
    public void initShortcutBarFragmentAdapter() {
        mAdapter=mView.initShortcutBarFragmentAdapter();
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
    public void getShortcutBarData() {
        mData.clear();
        mData.addAll(mModel.getShortcutBarData());
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 获取快捷栏的宽度
     */
    @Override
    public int getLayoutWidth() {
        return mView.getArguments().getInt("width");
    }

}
