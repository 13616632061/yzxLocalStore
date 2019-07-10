package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yzx.lib.base.BaseActivity;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.presenter.AddGoodsInfoActivityPresenter;
import com.yzx.yzxlocalstore.ui.Adapter.SpinnerAdapter;
import com.yzx.yzxlocalstore.ui.Adapter.SpinnerGoodsTypeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

@Route(path = RouteMap.ROUTE_ADD_GOODS_INFO_ACTIVITY)
public class AddGoodsInfoActivity extends BaseActivity implements IAddGoodsInfoActivityView {


    @InjectView(R.id.spinner_good_type)
    Spinner spinnerGoodType;
    @InjectView(R.id.et_good_name)
    EditText etGoodName;
    @InjectView(R.id.et_good_code)
    EditText etGoodCode;
    @InjectView(R.id.et_good_pinyin_code)
    EditText etGoodPinyinCode;
    @InjectView(R.id.et_good_store)
    EditText etGoodStore;
    @InjectView(R.id.et_good_warning_store)
    EditText etGoodWarningStore;
    @InjectView(R.id.rbtn_up)
    RadioButton rbtnUp;
    @InjectView(R.id.rbt_down)
    RadioButton rbtDown;
    @InjectView(R.id.rbtn_no_location)
    RadioButton rbtnNoLocation;
    @InjectView(R.id.rbt_quick_bar)
    RadioButton rbtQuickBar;
    @InjectView(R.id.rbt_weight_bar)
    RadioButton rbtWeightBar;
    @InjectView(R.id.et_good_original_price)
    EditText etGoodOriginalPrice;
    @InjectView(R.id.et_good_price)
    EditText etGoodPrice;
    @InjectView(R.id.tv_profit)
    TextView tvProfit;
    @InjectView(R.id.et_good_vip_level_one_price)
    EditText etGoodVipLevelOnePrice;
    @InjectView(R.id.tv_vip1_profit)
    TextView tvVip1Profit;
    @InjectView(R.id.et_good_vip_level_two_price)
    EditText etGoodVipLevelTwoPrice;
    @InjectView(R.id.tv_vip2_profit)
    TextView tvVip2Profit;
    @InjectView(R.id.et_good_vip_level_three_price)
    EditText etGoodVipLevelThreePrice;
    @InjectView(R.id.tv_vip3_profit)
    TextView tvVip3Profit;
    @InjectView(R.id.et_good_vip_level_fourprice)
    EditText etGoodVipLevelFourprice;
    @InjectView(R.id.tv_vip4_profit)
    TextView tvVip4Profit;
    @InjectView(R.id.et_good_vip_level_five_price)
    EditText etGoodVipLevelFivePrice;
    @InjectView(R.id.tv_vip5_profit)
    TextView tvVip5Profit;

    private AddGoodsInfoActivityPresenter mPresenter;


    @Override
    public int getContentView() {
        return R.layout.activity_add_goods_info;
    }

    @Override
    protected void initView() {
        inintTitle(getResources().getString(R.string.add_goods));
        mPresenter = new AddGoodsInfoActivityPresenter(this);
        mPresenter.setGoodType();
    }

    @OnClick({R.id.btn_cancel, R.id.btn_sure})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel://取消
                finish();
                break;
            case R.id.btn_sure://确定
                break;
        }
    }
    //商品分类
    @Override
    public void setGoodType(final List<GoodsType> spinnerItems) {
        SpinnerGoodsTypeAdapter spinnerAdapter = new SpinnerGoodsTypeAdapter(this, R.layout.item_select);
        spinnerAdapter.setDatas(spinnerItems);
        spinnerGoodType.setAdapter(spinnerAdapter);
        spinnerGoodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mPresenter.getSelectedGoodType(spinnerItems.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public GoodsType getGoodType(GoodsType goodsType) {
        return goodsType;
    }

    @Override
    public void setGoodName(String goodName) {
        etGoodName.setText(goodName);
    }

    @Override
    public String getGoodName() {
        return etGoodName.getText().toString().trim();
    }

    @Override
    public void setGoodCode(String goodCode) {
        etGoodCode.setText(goodCode);
    }

    @Override
    public String getGoodCode() {
        return etGoodCode.getText().toString().trim();
    }

    @Override
    public void setGoodPinyinCode(String pinyinCode) {
        etGoodPinyinCode.setText(pinyinCode);
    }

    @Override
    public String getGoodPinyinCode() {
        return etGoodPinyinCode.getText().toString().trim();
    }

    @Override
    public void setGoodStore(String store) {
        etGoodStore.setText(store);
    }

    @Override
    public String getGoodStore() {
        return etGoodStore.getText().toString().trim();
    }

    @Override
    public void setGoodStoreWarningNum(String storeWarningNum) {
        etGoodWarningStore.setText(storeWarningNum);
    }

    @Override
    public String getGoodStoreWarningNum() {
        return etGoodWarningStore.getText().toString().trim();
    }

    @Override
    public void setGoodStatus(boolean status) {

    }

    @Override
    public boolean getGoodStatus() {
        return false;
    }

    @Override
    public void setGoodLoaction(int loaction) {

    }

    @Override
    public int getGoodLoaction() {
        return 0;
    }

    @Override
    public void setGoodOriginalPrice(String originalPrice) {
        etGoodOriginalPrice.setText(originalPrice);
    }

    @Override
    public String getGoodOriginalPrice() {
        return etGoodOriginalPrice.getText().toString().trim();
    }

    @Override
    public void setGoodPrice(String price) {
        etGoodPrice.setText(price);
    }

    @Override
    public String getGoodPrice() {
        return etGoodPrice.getText().toString().trim();
    }

    @Override
    public void setGoodVipLevelOnePrice(String vipLevelOnePrice) {
        etGoodVipLevelOnePrice.setText(vipLevelOnePrice);
    }

    @Override
    public String getGoodVipLevelOnePrice() {
        return etGoodVipLevelOnePrice.getText().toString().trim();
    }

    @Override
    public void setGoodVipLevelTwoPrice(String vipLevelTwoPrice) {
        etGoodVipLevelTwoPrice.setText(vipLevelTwoPrice);
    }

    @Override
    public String getGoodVipLevelTwoPrice() {
        return etGoodVipLevelTwoPrice.getText().toString().trim();
    }

    @Override
    public void setGoodVipLevelThreePrice(String vipLevelThreePrice) {
        etGoodVipLevelThreePrice.setText(vipLevelThreePrice);
    }

    @Override
    public String getGoodVipLevelThreePrice() {
        return etGoodVipLevelThreePrice.getText().toString().trim();
    }

    @Override
    public void setGoodVipLevelFourthPrice(String vipLevelFourthPrice) {
        etGoodVipLevelFourprice.setText(vipLevelFourthPrice);
    }

    @Override
    public String getGoodVipLevelFourthPrice() {
        return etGoodVipLevelFourprice.getText().toString().trim();
    }

    @Override
    public void setGoodVipLevelFivePrice(String vipLevelFivePrice) {
        etGoodVipLevelFivePrice.setText(vipLevelFivePrice);
    }

    @Override
    public String getGoodVipLevelFivePrice() {
        return etGoodVipLevelFivePrice.getText().toString().trim();
    }

    //错误信息提示
    @Override
    public void errorMsg(int type) {
        switch (type) {
            case 0:
                showToast(getResources().getString(R.string.empty_goods_name));
                break;
            case 1:
                showToast(getResources().getString(R.string.empty_goods_code));
                break;
            case 2:
                showToast(getResources().getString(R.string.empty_goods_pinyin_code));
                break;
            case 3:
                showToast(getResources().getString(R.string.empty_goods_store));
                break;
            case 4:
                showToast(getResources().getString(R.string.empty_goods_warning_store_num));
                break;
            case 5:
                showToast(getResources().getString(R.string.empty_goods_original_price));
                break;
            case 6:
                showToast(getResources().getString(R.string.empty_goods_price));
                break;

        }
    }

}
