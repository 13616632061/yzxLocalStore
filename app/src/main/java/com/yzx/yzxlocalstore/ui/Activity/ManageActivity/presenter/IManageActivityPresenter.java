package com.yzx.yzxlocalstore.ui.Activity.ManageActivity.presenter;

import com.chaychan.library.BottomBarItem;
import com.yzx.yzxlocalstore.entity.ManageType;

/**
 * Created by lyf on 2019/5/7.
 */

public interface IManageActivityPresenter {
   /**
    * 初始化分类
    */
   void initManageType();

   /**
    * 创建顶部分类item
    * @param manageType
    * @return
    */
   BottomBarItem createTopBarItem(ManageType manageType);
}
