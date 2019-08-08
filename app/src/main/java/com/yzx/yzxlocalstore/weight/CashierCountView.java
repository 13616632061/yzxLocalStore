package com.yzx.yzxlocalstore.weight;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.yzx.lib.util.ArithUtil;
import com.yzx.lib.weight.CashierInputFilter;
import com.yzx.yzxlocalstore.R;

import butterknife.OnClick;


/**
 * Created by Administrator on 2019/8/1.
 * 收银计算view
 */

public class CashierCountView extends FrameLayout implements View.OnClickListener {

    private Context mContext;
    private View view;
    private View layout_receivable;//应收
    private TextView tv_receivable;
    private View layout_receipts;//实收
    private TextView tv_receipts;
    private View layout_change;//找零
    private TextView tv_change;
    private Button btn_vertical_reduction;//立减
    private Button btn_discount;//折扣
    private TextView tv_free_money;//优惠金额
    private Button btn_one_hundred, btn_fifty, btn_twenty, btn_ten;
    private Button btn_remove, btn_add, btn_point;
    private Button btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five;
    private Button btn_six, btn_seven, btn_eight, btn_nine;
    private Button btn_membership_payment, btn_cash_payment, btn_mobile_payment;

    public paymentType mPaymentType;


    public CashierCountView(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public CashierCountView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CashierCountView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CashierCountView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context mContext) {
        this.mContext = mContext;
        view = View.inflate(mContext, R.layout.cashier_count_layout, null);
        initViewFindViewById();
        setInputFilter();
        addView(view);
    }

    /**
     * 设置显示限制
     * 默认控制输入10位数，小数点前7位，后2位，小数一位，共10位
     */

    private void setInputFilter() {
        InputFilter[] filters = {new CashierInputFilter(10), new InputFilter.LengthFilter(10)};
        tv_receivable.setFilters(filters);
        tv_receipts.setFilters(filters);
        tv_change.setFilters(filters);
        tv_free_money.setFilters(filters);
    }

    /***
     * 初始化id
     */
    private void initViewFindViewById() {
        layout_receivable = view.findViewById(R.id.layout_receivable);
        layout_receipts = view.findViewById(R.id.layout_receipts);
        layout_change = view.findViewById(R.id.layout_change);
        tv_receivable = view.findViewById(R.id.tv_receivable);
        tv_receipts = view.findViewById(R.id.tv_receipts);
        tv_change = view.findViewById(R.id.tv_change);
        btn_vertical_reduction = view.findViewById(R.id.btn_vertical_reduction);
        btn_discount = view.findViewById(R.id.btn_discount);
        tv_free_money = view.findViewById(R.id.tv_free_money);
        btn_one_hundred = view.findViewById(R.id.btn_one_hundred);
        btn_fifty = view.findViewById(R.id.btn_fifty);
        btn_twenty = view.findViewById(R.id.btn_twenty);
        btn_ten = view.findViewById(R.id.btn_ten);
        btn_remove = view.findViewById(R.id.btn_remove);
        btn_add = view.findViewById(R.id.btn_add);
        btn_point = view.findViewById(R.id.btn_point);
        btn_zero = view.findViewById(R.id.btn_zero);
        btn_one = view.findViewById(R.id.btn_one);
        btn_two = view.findViewById(R.id.btn_two);
        btn_three = view.findViewById(R.id.btn_three);
        btn_four = view.findViewById(R.id.btn_four);
        btn_five = view.findViewById(R.id.btn_five);
        btn_six = view.findViewById(R.id.btn_six);
        btn_seven = view.findViewById(R.id.btn_seven);
        btn_eight = view.findViewById(R.id.btn_eight);
        btn_nine = view.findViewById(R.id.btn_nine);
        btn_membership_payment = view.findViewById(R.id.btn_membership_payment);
        btn_cash_payment = view.findViewById(R.id.btn_cash_payment);
        btn_mobile_payment = view.findViewById(R.id.btn_mobile_payment);

        btn_zero.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_ten.setOnClickListener(this);
        btn_twenty.setOnClickListener(this);
        btn_fifty.setOnClickListener(this);
        btn_one_hundred.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_remove.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_discount.setOnClickListener(this);
        btn_vertical_reduction.setOnClickListener(this);
        btn_membership_payment.setOnClickListener(this);
        btn_cash_payment.setOnClickListener(this);
        btn_mobile_payment.setOnClickListener(this);

    }

    /**
     * 设置应收金额
     *
     * @param money
     */
    public void setReceivableMoney(String money) {
        String moneyStr = "0.00";
        if (!TextUtils.isEmpty(money)) {
            moneyStr = money;
        }
        tv_receivable.setText(ArithUtil.roundByScale(moneyStr, "#0.00"));
    }

    /**
     * 找零
     */
    public void setChangeMoney() {
        String receivableMoney = tv_receivable.getText().toString().trim();
        String receiptsMoney = tv_receipts.getText().toString().trim();
        double changeMoney = ArithUtil.sub(receiptsMoney, receivableMoney);
        tv_change.setText(ArithUtil.roundByScale(changeMoney + "", "#0.00"));
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        String str = tv_receipts.getText().toString();
        switch (v.getId()) {
            case R.id.btn_zero:
            case R.id.btn_one:
            case R.id.btn_two:
            case R.id.btn_three:
            case R.id.btn_four:
            case R.id.btn_five:
            case R.id.btn_six:
            case R.id.btn_seven:
            case R.id.btn_eight:
            case R.id.btn_nine:
            case R.id.btn_ten:
            case R.id.btn_twenty:
            case R.id.btn_fifty:
            case R.id.btn_one_hundred:
            case R.id.btn_point:
                // 点击数字按钮和小数点时，在文本内追加内容
                tv_receipts.setText(str + ((Button) v).getText().toString());
                setChangeMoney();
                break;
            case R.id.btn_add:

                break;
            case R.id.btn_remove:
                // 点击删除按钮，删除一个字符
                if (str != null && !str.equals("")) {
                    str = str.substring(0, str.length() - 1);
                    tv_receipts.setText(str);
                    setChangeMoney();
                }
                break;
            case R.id.btn_vertical_reduction:
                break;
            case R.id.btn_discount:
                break;
            case R.id.btn_membership_payment://会员支付
                if (mPaymentType != null) mPaymentType.membershipPayment();
                break;
            case R.id.btn_cash_payment://现金支付
                if (mPaymentType != null) mPaymentType.cashPayment();
                break;
            case R.id.btn_mobile_payment://移动支付
                if (mPaymentType != null) mPaymentType.mobilePayment();
                break;
        }
    }

    public interface paymentType {
        void membershipPayment();

        void cashPayment();

        void mobilePayment();
    }

    public void setPaymentType(paymentType mPaymentType) {
        this.mPaymentType = mPaymentType;
    }
}
