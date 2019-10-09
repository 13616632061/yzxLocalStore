package com.yzx.yzxlocalstore.ui.Fragment.MainGoodsBarFragment.WeightBarFragment.view;

import com.yzx.yzxlocalstore.ui.Adapter.ShortcutBarFragmentAdapter;
import com.yzx.yzxlocalstore.ui.Adapter.WeightBarFragmentTypeAdapter;

/**
 * Created by Administrator on 2019/10/8.
 */

public interface IWeightBarFragmentView {

    //初始化计重栏商品分类
    WeightBarFragmentTypeAdapter initWeightBarFragmentTypeAdapter();

    //初始化计重栏商品
    ShortcutBarFragmentAdapter initWeightBarFragmentAdapter();
}
