package com.example.sgr.wzd.module.Tale;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseMvpLceFragment;
import com.example.sgr.wzd.config.Constant;
import com.example.sgr.wzd.module.My.set.SetMyActivity;
import com.example.sgr.wzd.module.Tale.company_brif.CompanyBrifActivity;
import com.example.sgr.wzd.module.common.CommonLcePresenter;
import com.example.sgr.wzd.module.common.CommonLceView;
import com.example.sgr.wzd.utils.StartActivityUtil;
import com.example.sgr.wzd.widget.TextItem;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaleFragment extends BaseMvpLceFragment<CommonLceView,CommonLcePresenter> implements CommonLceView {
    @BindView(R.id.rel_company)
    View rel_company;




    @OnClick({R.id.rel_company})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_company:
                StartActivityUtil.skipAnotherActivity(getActivity(), CompanyBrifActivity.class);
                break;

        }
    }
    public TaleFragment() {
        // Required empty public constructor
    }
    @Override
    public int getContentView() {
        return R.layout.fragment_tale;
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
