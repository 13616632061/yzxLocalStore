package com.yzx.lib.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.squareup.leakcanary.RefWatcher;
import com.yzx.lib.app.LibAplication;

import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by lyf on 2019/4/29.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private static Activity mCurrentActivity;

    private static List<Activity> mActivities=new LinkedList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());

        ButterKnife.inject(this);
        //路由自动属性注入
        ARouter.getInstance().inject(this);

        synchronized (mActivities){
            mActivities.add(this);
        }

        initView();
    }

    /**
     * 返回布局id
     *
     * @return
     */

    public abstract int getContentView();

    /**
     * 初始化view
     */
    protected abstract void initView();

    @Override
    protected void onResume() {
        super.onResume();
        mCurrentActivity=this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCurrentActivity=null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //测试内存泄漏，正式一定要隐藏
        RefWatcher refWatcher = LibAplication.getRefWatcher(this);//1
        refWatcher.watch(this);

        synchronized (mActivities){
            mActivities.remove(this);
        }

    }
}
