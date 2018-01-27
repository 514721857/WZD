package com.example.sgr.wzd.module.Tale.company_brif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.BaseActivity;
import com.example.sgr.wzd.utils.StartActivityUtil;

import butterknife.BindView;
import butterknife.OnClick;

public class CompanyBrifActivity extends BaseActivity {

    View rel_company;


    @BindView(R.id.setmy_finsh)
    TextView setmy_finsh;

    @BindView(R.id.setmy_title)
    TextView setmy_title;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_company_brif;
    }
    @OnClick({R.id.setmy_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setmy_back:
                finish();
                break;

        }
    }
    @Override
    protected void initView() {
        super.initView();
        setmy_title.setText(getString(R.string.home_title_tale));
        setmy_finsh.setVisibility(View.GONE);
    }
}
