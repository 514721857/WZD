package com.example.sgr.wzd.module.Real;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseMvpLceFragment;
import com.example.sgr.wzd.module.common.CommonLcePresenter;
import com.example.sgr.wzd.module.common.CommonLceView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RealFragment extends BaseMvpLceFragment<CommonLceView,CommonLcePresenter> implements CommonLceView  {


    public RealFragment() {
        // Required empty public constructor
    }



    @Override
    public int getContentView() {
        return R.layout.fragment_real;
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
