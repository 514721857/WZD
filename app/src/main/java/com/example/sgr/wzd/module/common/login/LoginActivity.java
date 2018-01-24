package com.example.sgr.wzd.module.common.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseLceActivity;
import com.tz.mvp.framework.base.presenter.MvpPresenter;

public class LoginActivity extends BaseLceActivity <LoginView,LoginPresenter> implements LoginView{

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }
}
