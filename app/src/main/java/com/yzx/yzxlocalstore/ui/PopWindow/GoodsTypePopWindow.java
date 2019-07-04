package com.yzx.yzxlocalstore.ui.PopWindow;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.yzx.lib.util.ScreenUtil;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.entity.GoodsType;
import com.yzx.yzxlocalstore.ui.Adapter.SpinnerAdapter;
import com.yzx.yzxlocalstore.ui.Fragment.GoodsTypeFragment.presenter.GoodsTypeFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/7/2.
 */

public class GoodsTypePopWindow extends PopupWindow implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private View view;
    private Context mContext;
    private TextView tv_title;
    private EditText et_type_name;
    private EditText et_sort;
    private Button btn_cancel;
    private Button btn_sure;
    private Spinner spinner;
    private LinearLayout layout_status;
    private GoodsTypeFragmentPresenter mPresenter;
    private boolean isEnable;//是否启用
    private GoodsType goodsType;
    private int type;//1添加，2编辑

    public GoodsTypePopWindow(Context context, String title, GoodsType goodsType, int type, GoodsTypeFragmentPresenter mPresenter) {
        super(context);
        mContext = context;
        this.mPresenter = mPresenter;
        this.goodsType = goodsType;
        this.type = type;
        view = View.inflate(context, R.layout.layout_goods_type_pop, null);

        initSet();
        initView(title);
    }

    private void initView(String title) {
        tv_title = view.findViewById(R.id.tv_title);
        et_type_name = view.findViewById(R.id.et_type_name);
        et_sort = view.findViewById(R.id.et_sort);
        btn_sure = view.findViewById(R.id.btn_sure);
        btn_cancel = view.findViewById(R.id.btn_cancel);
        spinner = view.findViewById(R.id.spinner);
        layout_status = view.findViewById(R.id.layout_status);

        tv_title.setText(title);
        List<String> spinnerItems = new ArrayList<>();
        spinnerItems.add(mContext.getResources().getString(R.string.enable));
        spinnerItems.add(mContext.getResources().getString(R.string.forbidden));
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(mContext, R.layout.item_select);
        spinnerAdapter.setDatas(spinnerItems);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(this);

        switch (type) {
            case 1://添加
                layout_status.setVisibility(View.GONE);
                break;
            case 2://编辑
                layout_status.setVisibility(View.VISIBLE);
                //编辑时，分类名显示
                if (goodsType != null && !TextUtils.isEmpty(goodsType.getTypeName())) {
                    et_type_name.setText(goodsType.getTypeName());
                    et_type_name.setSelection(goodsType.getTypeName().length());
                }
                //编辑时，排序显示
                if (goodsType != null && !TextUtils.isEmpty(goodsType.getSort() + "")) {
                    et_sort.setText(goodsType.getSort() + "");
                    et_sort.setSelection((goodsType.getSort() + "").length());
                }
                //编辑时，状态显示
                if (goodsType != null) {
                    if (goodsType.getStatus()) {
                        isEnable = true;
                        spinner.setSelection(0);
                    } else {
                        isEnable = false;
                        spinner.setSelection(1);
                    }
                }
                break;
        }

        btn_cancel.setOnClickListener(this);
        btn_sure.setOnClickListener(this);

    }

    private void initSet() {
        this.setContentView(view);
        //sdk > 21 解决 标题栏没有办法遮罩的问题
        this.setClippingEnabled(false);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.MATCH_PARENT);//屏幕的高
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.AnimationWindow);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x80000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sure:
                sureGoodsTypeInfo(type);
                break;
            case R.id.btn_cancel:
                dismiss();
                break;
        }
    }

    private void sureGoodsTypeInfo(int type) {
        String typeName = et_type_name.getText().toString().trim();
        String sort = et_sort.getText().toString().trim();
        if (TextUtils.isEmpty(typeName)) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.input_goods_type_name), Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(sort)) {
            Toast.makeText(mContext, mContext.getResources().getString(R.string.input_goods_type_sort), Toast.LENGTH_SHORT).show();
            return;
        }
        switch (type) {
            case 1:
                mPresenter.addGoodsType(typeName, sort);
                break;
            case 2:
                goodsType.setTypeName(typeName);
                goodsType.setSort(Integer.parseInt(sort));
                goodsType.setStatus(isEnable);
                mPresenter.editGoodsType(goodsType);
                break;
        }
        dismiss();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            isEnable = true;
        } else {
            isEnable = false;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
