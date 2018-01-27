package com.example.sgr.wzd.module.My;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseMvpLceFragment;
import com.example.sgr.wzd.config.Constant;
import com.example.sgr.wzd.module.My.set.SetMyActivity;
import com.example.sgr.wzd.module.common.CommonLcePresenter;
import com.example.sgr.wzd.module.common.CommonLceView;
import com.example.sgr.wzd.utils.StartActivityUtil;
import com.example.sgr.wzd.widget.TextItem;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class MyFragment extends BaseMvpLceFragment<CommonLceView,CommonLcePresenter> implements CommonLceView {

    @BindView(R.id.my_head)
    TextItem my_head;

    @BindView(R.id.my_name)
    TextItem my_name;

    @BindView(R.id.my_sex)
    TextItem my_sex;

    @BindView(R.id.my_job)
    TextItem my_job;

    @BindView(R.id.my_phone)
    TextItem my_phone;

    @BindView(R.id.my_account)
    TextItem my_account;

    @Override
    public int getContentView() {
        return R.layout.fragment_my;
    }

    @OnClick({R.id.my_head,R.id.my_name,R.id.my_sex,R.id.my_job,R.id.my_phone,R.id.my_account})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.my_head:

                break;
            case R.id.my_name:
                HashMap<String,Integer> hashMap_name = new HashMap<>();
                hashMap_name.put(Constant.MY_KEY,Constant.MY_VALUE_NAME);
                StartActivityUtil.skipAnotherActivity(getActivity(), SetMyActivity.class,hashMap_name);
                break;
            case R.id.my_sex:
                HashMap<String,Integer> hashMap_sex = new HashMap<>();
                hashMap_sex.put(Constant.MY_KEY,Constant.MY_VALUE_SEX);
                StartActivityUtil.skipAnotherActivity(getActivity(), SetMyActivity.class,hashMap_sex);
                break;
            case R.id.my_job:
                HashMap<String,Integer> hashMap_job = new HashMap<>();
                hashMap_job.put(Constant.MY_KEY,Constant.MY_VALUE_JOB);
                StartActivityUtil.skipAnotherActivity(getActivity(), SetMyActivity.class,hashMap_job);
                break;
            case R.id.my_phone:
                HashMap<String,Integer> hashMap_phone = new HashMap<>();
                hashMap_phone.put(Constant.MY_KEY,Constant.MY_VALUE_PHONE);
                StartActivityUtil.skipAnotherActivity(getActivity(), SetMyActivity.class,hashMap_phone);
                break;
            case R.id.my_account:

                break;
        }
    }
    @Override
    public void initContentView(View contentView) {

    }

    @Override
    public void initNavigation(View contentView) {

    }

    @Override
    public CommonLcePresenter createPresenter() {
        return new CommonLcePresenter(getActivity());
    }
}
