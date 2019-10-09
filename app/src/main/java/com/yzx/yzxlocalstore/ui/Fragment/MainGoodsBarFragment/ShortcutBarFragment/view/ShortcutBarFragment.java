package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.view;

import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.apkfuns.logutils.LogUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.lib.entity.MessageEvent;
import com.yzx.lib.util.EventBusMapUtil;
import com.yzx.lib.weight.GridSpacingItemDecoration;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.ui.Adapter.ShortcutBarFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.ShortcutBarFragment.presenter.ShortcutBarFragmentPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2019/10/8.
 */

public class ShortcutBarFragment extends BaseFragment implements IShortcutBarFragmentView{
    @InjectView(R.id.list)
    RecyclerView list;

    private ShortcutBarFragmentPresenter mPresenter;



    @Override
    protected int setContentViewId() {
        return R.layout.fragment_shortcut_bar;
    }

    @Override
    protected void loadData() {
        EventBus.getDefault().register(this);
        mPresenter=new ShortcutBarFragmentPresenter(this);
        mPresenter.initShortcutBarFragmentAdapter();
        mPresenter.getShortcutBarData() ;
    }

    /**
     * 初始化快捷商品适配器
     * @return
     */
    @Override
    public ShortcutBarFragmentAdapter initShortcutBarFragmentAdapter() {
        LogUtils.w("LayoutWidth: "+mPresenter.getLayoutWidth());
        ShortcutBarFragmentAdapter adapter=new ShortcutBarFragmentAdapter(R.layout.item_short_cut,mPresenter.getData(), mPresenter.getLayoutWidth(),5);
        GridSpacingItemDecoration decoration=new GridSpacingItemDecoration(5, ConvertUtils.dp2px(10),true);
        list.addItemDecoration(decoration);
        list.setLayoutManager(new GridLayoutManager(getActivity(),5));
        list.setAdapter(adapter);
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
            mPresenter.getShortcutBarData() ;
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }
}
