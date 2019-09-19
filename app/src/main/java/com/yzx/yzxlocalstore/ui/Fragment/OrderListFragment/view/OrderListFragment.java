package com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.ui.Adapter.OrderListFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.OrderListFragment.presenter.OrderListFragmentPresenter;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/9/17.
 */

public class OrderListFragment extends BaseFragment implements IOrderListFragmentView {
    @InjectView(R.id.tv_all_order)
    TextView tvAllOrder;
    @InjectView(R.id.tv_no_pay_order)
    TextView tvNoPayOrder;
    @InjectView(R.id.tv_completed_order)
    TextView tvCompletedOrder;
    @InjectView(R.id.tv_put_order)
    TextView tvPutOrder;
    @InjectView(R.id.tv_invalid_order)
    TextView tvInvalidOrder;
    @InjectView(R.id.tv_search)
    TextView tvSearch;
    @InjectView(R.id.iv_all_select)
    ImageView ivAllSelect;
    @InjectView(R.id.list)
    RecyclerView list;
    @InjectView(R.id.btn_order_invalid)
    Button btnOrderInvalid;
    @InjectView(R.id.btn_export)
    Button btnExport;
    @InjectView(R.id.btn_print)
    Button btnPrint;
    @InjectView(R.id.tv_max_show_page)
    TextView tvMaxShowPage;
    @InjectView(R.id.tv_bottom_right)
    TextView tvBottomRight;
    @InjectView(R.id.tv_first_page)
    TextView tvFirstPage;
    @InjectView(R.id.tv_pre_page)
    TextView tvPrePage;
    @InjectView(R.id.tv_next_page)
    TextView tvNextPage;
    @InjectView(R.id.tv_last_page)
    TextView tvLastPage;


    private OrderListFragmentPresenter mPresenter;

    @Override
    protected int setContentViewId() {
        return R.layout.fragment_order_list;
    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        mPresenter = new OrderListFragmentPresenter(this);
        mPresenter.setOrderListType(getArguments().getInt("type"));
        mPresenter.initOrderListFragmentAdapter();
    }

    @Override
    protected void loadData() {
        mPresenter.getOrderListInfo(1, 0);
        mPresenter.updateOrderNum();
    }

    @OnClick({R.id.tv_all_order,R.id.tv_no_pay_order,R.id.tv_completed_order,R.id.tv_put_order,R.id.tv_invalid_order})
    public void setOnClick(View view){
        switch (view.getId()){
            case R.id.tv_all_order:
                mPresenter.getOrderListInfo(1, 0);
                break;
            case R.id.tv_no_pay_order:
                mPresenter.getOrderListInfo(1, 1);
                break;
            case R.id.tv_completed_order:
                mPresenter.getOrderListInfo(1, 2);
                break;
            case R.id.tv_put_order:
                mPresenter.getOrderListInfo(1, 3);
                break;
            case R.id.tv_invalid_order:
                mPresenter.getOrderListInfo(1, 4);
                break;
        }
    }
    /**
     * 初始化订单列表
     *
     * @return
     */
    @Override
    public OrderListFragmentAdapter initOrderListFragmentAdapter() {
        OrderListFragmentAdapter adapter = new OrderListFragmentAdapter(getActivity(), R.layout.item_order_list_fragment, mPresenter.getData());
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_select://选中
                        break;
                    case R.id.tv_handle://查看详情
                        break;
                }
            }
        });
        return adapter;
    }

    /**
     * 所有订单数量
     *
     * @param num
     */
    @Override
    public void setAllOrderNum(String num) {
        tvAllOrder.setText(getResources().getString(R.string.alls) + "(" + num + ")");
    }

    /**
     * 未支付订单数量
     *
     * @param num
     */
    @Override
    public void setNoPayOrder(String num) {
        tvNoPayOrder.setText(getResources().getString(R.string.no_pay) + "(" + num + ")");
    }

    /**
     * 完成订单数量
     *
     * @param num
     */
    @Override
    public void setCompletedOrder(String num) {
        tvCompletedOrder.setText(getResources().getString(R.string.completed) + "(" + num + ")");
    }

    /**
     * 挂单订单数量
     *
     * @param num
     */
    @Override
    public void setPutOrder(String num) {
        tvPutOrder.setText(getResources().getString(R.string.put_order) + "(" + num + ")");

    }

    /**
     * 已作废订单数量
     *
     * @param num
     */
    @Override
    public void setInvalidOrder(String num) {
        tvInvalidOrder.setText(getResources().getString(R.string.invalid) + "(" + num + ")");
    }

    /**
     * 是否选中全部订单
     *
     * @param type 0未选中 1选中
     */
    @Override
    public void isSelectAllOrder(int type) {
        switch (type) {
            case 0:
                tvAllOrder.setTextColor(getResources().getColor(R.color.color_707070));
                break;
            case 1:
                tvAllOrder.setTextColor(getResources().getColor(R.color.color_f5260b));
                break;
        }
    }

    /**
     * 是否选中未支付订单
     *
     * @param type 0未选中 1选中
     */
    @Override
    public void isSelectNoPayOrder(int type) {
        switch (type) {
            case 0:
                tvNoPayOrder.setTextColor(getResources().getColor(R.color.color_707070));
                break;
            case 1:
                tvNoPayOrder.setTextColor(getResources().getColor(R.color.color_f5260b));
                break;
        }
    }

    /**
     * 是否选中完成订单
     *
     * @param type 0未选中 1选中
     */
    @Override
    public void isSelectCompletedOrder(int type) {
        switch (type) {
            case 0:
                tvCompletedOrder.setTextColor(getResources().getColor(R.color.color_707070));
                break;
            case 1:
                tvCompletedOrder.setTextColor(getResources().getColor(R.color.color_f5260b));
                break;
        }
    }

    /**
     * 是否选中挂单订单
     *
     * @param type 0未选中 1选中
     */
    @Override
    public void isSelectPutOrder(int type) {
        switch (type) {
            case 0:
                tvPutOrder.setTextColor(getResources().getColor(R.color.color_707070));
                break;
            case 1:
                tvPutOrder.setTextColor(getResources().getColor(R.color.color_f5260b));
                break;
        }
    }

    /**
     * 是否选中废订单数量
     *
     * @param type 0未选中 1选中
     */
    @Override
    public void isSelectInvalidOrder(int type) {
        switch (type) {
            case 0:
                tvInvalidOrder.setTextColor(getResources().getColor(R.color.color_707070));
                break;
            case 1:
                tvInvalidOrder.setTextColor(getResources().getColor(R.color.color_f5260b));
                break;
        }
    }
}
