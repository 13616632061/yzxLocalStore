package com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Adapter.GoodsTypeFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.presenter.GoodsTypeFragmentPresenter;
import com.yzx.yzxlocalstore.ui.PopWindow.GoodsTypePopWindow;
import com.yzx.yzxlocalstore.ui.PopWindow.TipsPopWindow;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypeFragment extends BaseFragment implements IGoodsTypeFragmentView {
    @InjectView(R.id.tv_goods_type_num)
    TextView tvGoodsTypeNum;
    @InjectView(R.id.iv_all_select)
    ImageView ivAllSelect;
    @InjectView(R.id.list)
    RecyclerView list;
    @InjectView(R.id.layout_goods_type)
    RelativeLayout layoutGoodsType;

    private GoodsTypeFragmentAdapter mAdapter;
    private List<GoodsType> datas = new ArrayList<>();
    private GoodsTypeFragmentPresenter mPresenter;
    private boolean isAllSelect = false;//是否全选

    @Override
    protected int setContentViewId() {
        return R.layout.goods_type_layout;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mPresenter = new GoodsTypeFragmentPresenter(this);
        mPresenter.initAdapter();
    }

    @Override
    protected void loadData() {
        mPresenter.getGoodsTypeInfo();
    }

    @OnClick({R.id.iv_all_select, R.id.btn_add, R.id.btn_delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_all_select:
                mPresenter.editGoodsTypeSelectStatus(0, 0);
                break;
            case R.id.btn_add:
                mPresenter.showGoodsTypePopWindow(1, null);
                break;
            case R.id.btn_delete:
                mPresenter.showGoodsTypePopWindow(3, null);
                break;
        }
    }

    //初始化适配器
    @Override
    public void initAdapter() {
        mAdapter = new GoodsTypeFragmentAdapter(R.layout.item_goods_type, datas);
        list.setAdapter(mAdapter);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_select:
                        mPresenter.editGoodsTypeSelectStatus(1, position);
                        break;
                    case R.id.tv_edit:
                        mPresenter.showGoodsTypePopWindow(2, datas.get(position));
                        break;
                }
            }
        });
    }

    @Override
    public GoodsTypeFragmentAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public List<GoodsType> getGoodsTypeDatas() {
        return datas;
    }

    //商品分类数量
    @Override
    public void setGoodsTypeNum(int num) {
        tvGoodsTypeNum.setText("(" + getResources().getString(R.string.all) + num + getResources().getString(R.string.strip) + ")");
    }

    //新增分类
    @Override
    public void addGoodsType() {
        GoodsTypePopWindow goodsTypePopWindow = new GoodsTypePopWindow(getActivity(), getResources().getString(R.string.add_goods_type), null, 1, mPresenter);
        goodsTypePopWindow.showAsDropDown(layoutGoodsType, Gravity.NO_GRAVITY, 0, 0);
    }

    //删除分类
    @Override
    public void deleteGoodsType() {
        TipsPopWindow tipsPopWindow = new TipsPopWindow(getActivity(), getResources().getString(R.string.reminder), getResources().getString(R.string.sure_delete_item), mPresenter, 1);
        tipsPopWindow.showAsDropDown(layoutGoodsType, Gravity.NO_GRAVITY, 0, 0);
    }

    //编辑分类
    @Override
    public void editGoodsType(GoodsType goodsType) {
        GoodsTypePopWindow goodsTypePopWindow = new GoodsTypePopWindow(getActivity(), getResources().getString(R.string.edit_goods_type), goodsType, 2, mPresenter);
        goodsTypePopWindow.showAsDropDown(layoutGoodsType, Gravity.NO_GRAVITY, 0, 0);
    }

    //是否全选
    @Override
    public void setAllSelect(boolean isAllSelect) {
        this.isAllSelect = isAllSelect;
    }

    @Override
    public boolean isAllSelect() {
        return isAllSelect;
    }

    //全选
    @Override
    public void allSelect() {
        if (isAllSelect) {
            ivAllSelect.setImageResource(R.drawable.select);
        } else {
            ivAllSelect.setImageResource(R.drawable.unselect);
        }
    }

    //操作提示信息
    @Override
    public void showToastMsg(int type) {
        switch (type) {
            case 1://分类名已存在，请重新输入！
                Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.goods_type_name_exist), Toast.LENGTH_SHORT).show();
                break;
            case 2://请选择要删除的分类信息
                Toast.makeText(getActivity(), getActivity().getResources().getString(R.string.selete_delete_item), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter = null;
        datas = null;
    }
}
