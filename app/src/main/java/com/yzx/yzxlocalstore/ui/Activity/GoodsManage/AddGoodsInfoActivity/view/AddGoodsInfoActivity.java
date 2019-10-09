package com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.apkfuns.logutils.LogUtils;
import com.yzx.lib.base.BaseActivity;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.app.MyAplication;
import com.yzx.yzxlocalstore.constant.RouteMap;
import com.yzx.yzxlocalstore.entity.GoodsInfo;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Activity.GoodsManage.AddGoodsInfoActivity.presenter.AddGoodsInfoActivityPresenter;
import com.yzx.yzxlocalstore.ui.Adapter.SpinnerGoodsTypeAdapter;

import java.security.Key;
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
    @InjectView(R.id.rg_status)
    RadioGroup rgStatus;
    @InjectView(R.id.rg_location)
    RadioGroup rgLocation;

    @Autowired(name = "type")
    public int mType;
    @Autowired(name = "mGoodsInfo")
    public GoodsInfo mGoodsInfo;

    private AddGoodsInfoActivityPresenter mPresenter;


    @Override
    public int getContentView() {
        return R.layout.activity_add_goods_info;
    }

    @Override
    protected void initView() {
        mPresenter = new AddGoodsInfoActivityPresenter(this);
        switch (mType) {
            case 1:
                inintTitle(getResources().getString(R.string.add_goods));
                break;
            case 2:
                inintTitle(getResources().getString(R.string.edit_goods));
                break;

        }
        mPresenter.getGoodType();
        mPresenter.setGoodInfo(mType, mGoodsInfo);
        mPresenter.showProfitInfo();

    }

    @OnClick({R.id.btn_cancel, R.id.btn_sure})
    public void setOnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel://取消
                finish();
                break;
            case R.id.btn_sure://确定
                mPresenter.saveGoodInfo(mType,mGoodsInfo);
                break;
        }
    }

    //商品分类
    @Override
    public void initGoodTypeInfo(List<String> mSpinnerGoodsTypeItems) {
        SpinnerGoodsTypeAdapter spinnerAdapter = new SpinnerGoodsTypeAdapter(this, R.layout.item_select);
        spinnerAdapter.setDatas(mSpinnerGoodsTypeItems);
        spinnerGoodType.setAdapter(spinnerAdapter);

        mPresenter.showSelectGoodType(mSpinnerGoodsTypeItems, mGoodsInfo, mType);

        spinnerGoodType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                selectGoodtype = spinnerItems.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    /**
     * 商品分类选中的item
     *
     * @param position
     */
    @Override
    public void setSelectGoodtypeItem(int position) {
        spinnerGoodType.setSelection(position);
    }


    @Override
    public String getSelectGoodType() {
        return (String) spinnerGoodType.getSelectedItem();
    }

    //商品名称
    @Override
    public void setGoodName(String goodName) {
        etGoodName.setText(goodName);
    }

    @Override
    public String getGoodName() {
        return etGoodName.getText().toString().trim();
    }

    //商品条码
    @Override
    public void setGoodCode(String goodCode) {
        etGoodCode.setText(goodCode);
    }

    @Override
    public String getGoodCode() {
        return etGoodCode.getText().toString().trim();
    }

    //商品拼音码
    @Override
    public void setGoodPinyinCode(String pinyinCode) {
        etGoodPinyinCode.setText(pinyinCode);
    }

    @Override
    public String getGoodPinyinCode() {
        return etGoodPinyinCode.getText().toString().trim();
    }

    //商品库存
    @Override
    public void setGoodStore(String store) {
        etGoodStore.setText(store);
    }

    @Override
    public String getGoodStore() {
        return etGoodStore.getText().toString().trim();
    }

    //库存预警数量
    @Override
    public void setGoodStoreWarningNum(String storeWarningNum) {
        etGoodWarningStore.setText(storeWarningNum);
    }

    @Override
    public String getGoodStoreWarningNum() {
        return etGoodWarningStore.getText().toString().trim();
    }

    //商品上下架状态
    @Override
    public void setGoodStatus(int type) {
        switch (type) {
            case 3://上架
                rgStatus.check(R.id.rbtn_up);
                break;
            case 4://下架
                rgStatus.check(R.id.rbt_down);
                break;
        }

    }

    @Override
    public boolean getGoodStatus() {
        if (rgStatus.getCheckedRadioButtonId() == R.id.rbtn_up) {
            return true;
        } else {
            return false;
        }
    }

    //商品栏目：1快捷栏，2计重栏
    @Override
    public void setGoodLoaction(int loaction) {
        switch (loaction) {
            case 0:
                rgLocation.check(R.id.rbtn_no_location);
                break;
            case 1://快捷栏
                rgLocation.check(R.id.rbt_quick_bar);
                break;
            case 2://计重栏
                rgLocation.check(R.id.rbt_weight_bar);
                break;
        }
    }

    @Override
    public int getGoodLoaction() {
        int loaction = 0;
        switch (rgLocation.getCheckedRadioButtonId()) {
            case R.id.rbtn_no_location:
                loaction = 0;
                break;
            case R.id.rbt_quick_bar://快捷栏
                loaction = 1;
                break;
            case R.id.rbt_weight_bar://计重栏
                loaction = 2;
                break;
        }
        return loaction;
    }

    //商品进价
    @Override
    public void setGoodOriginalPrice(String originalPrice) {
        etGoodOriginalPrice.setText(originalPrice);
    }

    @Override
    public String getGoodOriginalPrice() {
        return etGoodOriginalPrice.getText().toString().trim();
    }

    //商品销售价
    @Override
    public void setGoodPrice(String price) {
        etGoodPrice.setText(price);
    }

    @Override
    public String getGoodPrice() {
        return etGoodPrice.getText().toString().trim();
    }

    //会员V1等级价格
    @Override
    public void setGoodVipLevelOnePrice(String vipLevelOnePrice) {
        etGoodVipLevelOnePrice.setText(vipLevelOnePrice);
    }

    @Override
    public String getGoodVipLevelOnePrice() {
        return etGoodVipLevelOnePrice.getText().toString().trim();
    }

    //会员V2等级价格
    @Override
    public void setGoodVipLevelTwoPrice(String vipLevelTwoPrice) {
        etGoodVipLevelTwoPrice.setText(vipLevelTwoPrice);
    }

    @Override
    public String getGoodVipLevelTwoPrice() {
        return etGoodVipLevelTwoPrice.getText().toString().trim();
    }

    //会员V3等级价格
    @Override
    public void setGoodVipLevelThreePrice(String vipLevelThreePrice) {
        etGoodVipLevelThreePrice.setText(vipLevelThreePrice);
    }

    @Override
    public String getGoodVipLevelThreePrice() {
        return etGoodVipLevelThreePrice.getText().toString().trim();
    }

    //会员V4等级价格
    @Override
    public void setGoodVipLevelFourthPrice(String vipLevelFourthPrice) {
        etGoodVipLevelFourprice.setText(vipLevelFourthPrice);
    }

    @Override
    public String getGoodVipLevelFourthPrice() {
        return etGoodVipLevelFourprice.getText().toString().trim();
    }

    //会员V5等级价格
    @Override
    public void setGoodVipLevelFivePrice(String vipLevelFivePrice) {
        etGoodVipLevelFivePrice.setText(vipLevelFivePrice);
    }

    @Override
    public String getGoodVipLevelFivePrice() {
        return etGoodVipLevelFivePrice.getText().toString().trim();
    }

    //商品利润
    @Override
    public void setGoodProfit(String profit, int type) {
        LogUtils.e("profit"+type);

        switch (type) {
            case 0:
                mPresenter.setProfitTextView(tvProfit, profit);
                break;
            case 1:
                mPresenter.setProfitTextView(tvVip1Profit, profit);
                break;
            case 2:
                mPresenter.setProfitTextView(tvVip2Profit, profit);
                break;
            case 3:
                mPresenter.setProfitTextView(tvVip3Profit, profit);
                break;
            case 4:
                mPresenter.setProfitTextView(tvVip4Profit, profit);
                break;
            case 5:
                mPresenter.setProfitTextView(tvVip5Profit, profit);
                break;
        }
    }


    //计算利润
    @Override
    public void countProfit(final EditText view1, final EditText view2, final int type) {
        if (mType == 2) {
            mPresenter.setGoodProfit(view2.getText().toString().trim(), view1.getText().toString().trim(), type);
        }
        view1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.setGoodProfit(view2.getText().toString().trim(), view1.getText().toString().trim(), type);
            }
        });
        view2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mPresenter.setGoodProfit(view2.getText().toString().trim(), view1.getText().toString().trim(), type);
            }
        });
    }

    //显示利润
    @Override
    public void showProfitInfo() {
        mPresenter.countProfit(etGoodOriginalPrice, etGoodPrice, 0);
        mPresenter.countProfit(etGoodOriginalPrice, etGoodVipLevelOnePrice, 1);
        mPresenter.countProfit(etGoodOriginalPrice, etGoodVipLevelTwoPrice, 2);
        mPresenter.countProfit(etGoodOriginalPrice, etGoodVipLevelThreePrice, 3);
        mPresenter.countProfit(etGoodOriginalPrice, etGoodVipLevelFourprice, 4);
        mPresenter.countProfit(etGoodOriginalPrice, etGoodVipLevelFivePrice, 5);
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
            case 7:
                showToast(getResources().getString(R.string.exist_goods_name));
                break;
            case 8:
                showToast(getResources().getString(R.string.exist_goods_name));
                break;

        }
    }


}
