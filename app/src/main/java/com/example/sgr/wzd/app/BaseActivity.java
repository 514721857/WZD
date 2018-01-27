package com.example.sgr.wzd.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sgr.wzd.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Activity基类
 * Created by geyifeng on 2017/5/9.AppCompatActivity
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected ImmersionBar mImmersionBar;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());
        //绑定控件
        unbinder = ButterKnife.bind(this);
     //初始化沉浸式
        if (isImmersionBarEnabled())
            initImmersionBar();
        //初始化数据
        initData();
        //view与数据绑定
        initView();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
      /*  if (mImmersionBar != null)
            mImmersionBar.destroy();  //在BaseActivity里销毁
    }*/
    }
    protected abstract int setLayoutId();

    protected void initImmersionBar() {
        //在BaseActivity里初始化  因为界面需要，状态栏的背景都需要是以图片为背景，所以这里需要在每个Activity里的xml布局文件中加入  topview布局
        //        https://github.com/gyf-dev/ImmersionBar  最外面布局为realayout 可能会导致挡住标题栏



        mImmersionBar = ImmersionBar.with(this).statusBarDarkFont(true, 0.2f).statusBarView(R.id.top_view);
        mImmersionBar.init();

       /* mImmersionBar = ImmersionBar.with(this).fitsSystemWindows(true) .statusBarDarkFont(true, 0.2f)  ;
        mImmersionBar.init();*/
    }

    protected void initData() {
    }

    protected void initView() {
    }

    /**
     * 是否可以使用沉浸式
     * Is immersion bar enabled boolean.
     *
     * @return the boolean
     */
    protected boolean isImmersionBarEnabled() {
        return true;
    }
}
