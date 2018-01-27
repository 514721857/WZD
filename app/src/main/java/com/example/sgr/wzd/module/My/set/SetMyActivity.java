package com.example.sgr.wzd.module.My.set;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.baseLce.BaseLceActivity;
import com.example.sgr.wzd.config.Constant;
import com.example.sgr.wzd.module.common.login.LoginPresenter;
import com.example.sgr.wzd.module.common.login.LoginView;
import com.example.sgr.wzd.utils.StartActivityUtil;
import com.example.sgr.wzd.widget.ClearEditText;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class SetMyActivity extends BaseLceActivity<SetMyView,SetMyPresenter> implements SetMyView {


    @BindView(R.id.setmy_title)
    TextView setmy_title;

    @BindView(R.id.setmy_finsh)
    TextView setmy_finsh;

    @BindView(R.id.setmy_other)
    LinearLayout setmy_other;

    @BindView(R.id.setmy_sex)
    LinearLayout setmy_sex;

    @BindView(R.id.setmy_edit)
    ClearEditText setmy_edit;

    @BindView(R.id.setmy_boy)
    TextView setmy_boy;

    @BindView(R.id.setmy_girl)
    TextView setmy_girl;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_set_my;
    }
    @Override
    public SetMyPresenter createPresenter() {
        return new SetMyPresenter(this);
    }
    @OnClick({R.id.setmy_back,R.id.setmy_boy,R.id.setmy_girl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setmy_back:
                finish();
                break;
            case R.id.setmy_boy:
                onSetSex(1);
                break;
            case R.id.setmy_girl:
                onSetSex(0);
                break;
        }
    }

    @Override
    protected void initView() {
        super.initView();
        Intent intent = this.getIntent();
        int result = intent.getExtras().getInt(Constant.MY_KEY);
        switch(result){
            case Constant.MY_VALUE_NAME:
                setmy_title.setText(getString(R.string.setmy_name));
                setmy_edit.setHint(getString(R.string.setmy_name));
                break;
            case Constant.MY_VALUE_JOB:
                setmy_title.setText(getString(R.string.setmy_job));
                setmy_edit.setHint(getString(R.string.setmy_job));
                break;
            case Constant.MY_VALUE_SEX:
                setmy_title.setText(getString(R.string.setmy_sex));
                setmy_sex.setVisibility(View.VISIBLE);
                setmy_other.setVisibility(View.GONE);
                break;
            case Constant.MY_VALUE_PHONE:
                setmy_title.setText(getString(R.string.setmy_phone));
                setmy_edit.setHint(getString(R.string.setmy_phone));
                break;
        }
    }

    @Override
    public void onSetSex(int sex) {
        if(sex==0){//选中的是女孩
            setmy_girl.setBackgroundColor(getColor(R.color.colorPrimary));
            setmy_girl.setTextColor(getColor(R.color.colorWihte));
            setmy_boy.setBackgroundColor(getColor(R.color.colorWihte));
            setmy_boy.setTextColor(getColor(R.color.colorTextGray));
        }else{//选中的是男孩
            setmy_boy.setBackgroundColor(getColor(R.color.colorPrimary));
            setmy_girl.setBackgroundColor(getColor(R.color.colorWihte));
            setmy_boy.setTextColor(getColor(R.color.colorWihte));
            setmy_girl.setTextColor(getColor(R.color.colorTextGray));
        }

    }
}
