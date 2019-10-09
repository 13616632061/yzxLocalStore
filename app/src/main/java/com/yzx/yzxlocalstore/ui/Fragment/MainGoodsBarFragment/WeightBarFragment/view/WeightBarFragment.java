package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.view;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ConvertUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.lib.util.EventBusMapUtil;
import com.yzx.lib.weight.GridSpacingItemDecoration;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.ui.Adapter.ShortcutBarFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Adapter.WeightBarFragmentTypeAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.presenter.WeightBarFragmentPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2019/10/8.
 */

public class WeightBarFragment extends BaseFragment implements IWeightBarFragmentView{
    @InjectView(R.id.left_list)
    RecyclerView leftList;
    @InjectView(R.id.right_list)
    RecyclerView rightList;

    private WeightBarFragmentPresenter mPresenter;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_weight_bar;
    }

    @Override
    protected void loadData() {
        EventBus.getDefault().register(this);
        mPresenter=new WeightBarFragmentPresenter(this);
        mPresenter.initWeightBarFragmentTypeAdapter();
        mPresenter.getWeightBarFragmentTypeData();
        mPresenter.initWeightBarFragmentAdapter();
        mPresenter.getWeightBarData();
    }

    /**
     * 初始化计重栏商品分类
     */
    @Override
    public WeightBarFragmentTypeAdapter initWeightBarFragmentTypeAdapter() {
        WeightBarFragmentTypeAdapter adapter=new WeightBarFragmentTypeAdapter(R.layout.item_weight_bar_type,mPresenter.getDataType());
        rightList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightList.setAdapter(adapter);
        return adapter;
    }

    /**
     * 初始化计重栏商品
     */
    @Override
    public ShortcutBarFragmentAdapter initWeightBarFragmentAdapter() {
        ShortcutBarFragmentAdapter adapter=new ShortcutBarFragmentAdapter(R.layout.item_short_cut,mPresenter.getData(), mPresenter.getLayoutWidth(),4);
        GridSpacingItemDecoration decoration=new GridSpacingItemDecoration(4, ConvertUtils.dp2px(10),true);
        leftList.addItemDecoration(decoration);
        leftList.setLayoutManager(new GridLayoutManager(getActivity(),4));
        leftList.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                EventBus.getDefault().post(EventBusMapUtil.getObjectMap("addSaleGood", mPresenter.getData().get(position).getGoodCode()));
            }
        });
        return adapter;
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEven(MessageEvent msg) {
        if (msg.getKey().contains("addGoodsInfoSuccess")) {
            mPresenter.getWeightBarFragmentTypeData();
            mPresenter.getWeightBarData();
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
