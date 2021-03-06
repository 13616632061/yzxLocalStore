package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.TextUtils;

import com.yzx.lib.base.BaseFragment;
import com.yzx.yzxlocalstore.R;
import com.yzx.yzxlocalstore.constant.Constants;

import java.util.List;

import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.QTabView;

/**
 * Created by lyf on 2019/5/7.
 */

public class ManageFragmentAdapter extends FragmentPagerAdapter implements TabAdapter {

    private List<Fragment> fragmentList;
    private int type;//不同FragmentPager
    private Context context;

    public ManageFragmentAdapter(Context context, FragmentManager fm, List<Fragment> fragmentList, int type) {
        super(fm);
        this.context = context;
        this.fragmentList = fragmentList;
        this.type = type;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public ITabView.TabBadge getBadge(int position) {
        return null;
    }

    @Override
    public ITabView.TabIcon getIcon(int position) {
        return null;
    }

    @Override
    public ITabView.TabTitle getTitle(int position) {
        QTabView.TabTitle.Builder tabView = new QTabView.TabTitle.Builder();
        String[] tabTitle = null;
        switch (type) {
            case 0:
                tabView.setContent(Constants.MANAGE_TYPE[position]);
                break;
            case 1://员工管理
                tabTitle = new String[]{context.getResources().getString(R.string.staffManage),
                        context.getResources().getString(R.string.sensitive_operational_record)
                };
                tabView.setContent(tabTitle[position]);
                break;
            case 2://商品管理
                tabTitle = new String[]{context.getResources().getString(R.string.goods_list),
                        context.getResources().getString(R.string.goods_type)
                };
                tabView.setContent(tabTitle[position]);
                break;
            case 3://订单管理
                tabTitle = new String[]{context.getResources().getString(R.string.today_order),
                        context.getResources().getString(R.string.yesterday_order),
                        context.getResources().getString(R.string.all_order)
                };
                tabView.setContent(tabTitle[position]);
                break;
        }
        return tabView.setTextColor(0xFFf5260b, 0xFF757575)
                .setTextSize(15)
                .build();
    }

    @Override
    public int getBackground(int position) {
        return R.color.whilte;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        CharSequence title = null;
        switch (type) {
            case 0://管理类别（总）
                title = Constants.MANAGE_TYPE[position];
                break;
            case 1://员工管理类别
                title = Constants.STAFFER_MANAGE_TYPE[position];
                break;
            case 2://商品管理分类
                title = Constants.GOODS_MANAGE_TYPE[position];
                break;
        }
        return title;
    }
}
