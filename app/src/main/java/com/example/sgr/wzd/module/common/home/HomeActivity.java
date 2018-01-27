package com.example.sgr.wzd.module.common.home;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.BaseMvpActivity;
import com.example.sgr.wzd.app.MyApplication;
import com.example.sgr.wzd.app.baseLce.BaseLceActivity;
import com.example.sgr.wzd.module.Know.KnowFragment;
import com.example.sgr.wzd.module.My.MyFragment;
import com.example.sgr.wzd.module.Real.RealFragment;
import com.example.sgr.wzd.module.Shop.ShopFragment;
import com.example.sgr.wzd.module.Tale.TaleFragment;
import com.example.sgr.wzd.module.common.CommonPresenter;
import com.example.sgr.wzd.module.common.CommonView;
import com.tz.mvp.framework.support.view.MvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseMvpActivity<CommonView,CommonPresenter> implements CommonView {

    private MyFragment myFragment;
    private TaleFragment taleFragment;
    private ShopFragment shopFragment;
    private KnowFragment knowFragment;
    private RealFragment realFragment;


    @BindView(R.id.verify_layout)
    View verify_layout;


    @BindView(R.id.sign_layout)
    View sign_layout;

    @BindView(R.id.video_layout)
    View video_layout;

    @BindView(R.id.flight_layout)
    View flight_layout;

    @BindView(R.id.account_layout)
    View account_layout;




    @BindView(R.id.verify_image)
    ImageView verify_image;

    @BindView(R.id.flight_image)
    ImageView flight_image;

    @BindView(R.id.sign_image)
    ImageView sign_image;

    @BindView(R.id.video_image)
    ImageView video_image;

    @BindView(R.id.account_image)
    ImageView account_image;


    @BindView(R.id.verify_text)
    TextView verify_text;

    @BindView(R.id.sign_text)
    TextView sign_text;

    @BindView(R.id.video_text)
    TextView video_text;

    @BindView(R.id.flight_text)
    TextView flight_text;

    @BindView(R.id.account_text)
    TextView account_text;


    @BindView(R.id.home_sign)
    ImageView home_sign;

    @BindView(R.id.home_title)
    TextView home_title;


    private int chooseIndex = 0;//选择项
    private FragmentTransaction transaction;
    long firstTime;
    private boolean iscycle;



    @Override
    protected int setLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public CommonPresenter createPresenter() {
        return new CommonPresenter(this);
    }

    @Override
    protected void initView() {
        super.initView();
        setTabSelection(0);
    }

    @OnClick({R.id.verify_layout, R.id.sign_layout, R.id.video_layout, R.id.flight_layout,R.id.account_layout})
    public void onTabClick(View view) {
        switch (view.getId()) {
            case R.id.verify_layout:
                chooseIndex = 0;
                setTabSelection(0);

                break;
            case R.id.sign_layout:
                chooseIndex = 1;
                setTabSelection(1);

                break;
            case R.id.video_layout:
                chooseIndex = 2;
                setTabSelection(2);

                break;
            case R.id.flight_layout:
                chooseIndex = 3;
                setTabSelection(3);

                break;
            case R.id.account_layout:
                chooseIndex = 4;
                setTabSelection(4);
                break;
        }
    }


    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *
     */
    private void setTabSelection(int index) {
        transaction=  getFragmentManager().beginTransaction();
        hideFragments(transaction);
        setImageText(index);
        switch (index) {
            case 0:
                if (realFragment == null) {

                    realFragment = new RealFragment();
                    transaction.add(R.id.content, realFragment);
//                    transaction.add(R.id.content, realFragment);
                } else {

                    transaction.show(realFragment);
                }
                transaction.commit();
                home_title.setText(getString(R.string.home_title_real));
                home_sign.setVisibility(View.GONE);
                break;
            case 1:
                if (shopFragment == null) {
                    shopFragment = new ShopFragment();

                    transaction.add(R.id.content, shopFragment);
                } else {

                    transaction.show(shopFragment);
                }
                transaction.commit();

                home_sign.setVisibility(View.GONE);
                home_title.setText(getString(R.string.home_title_shop));
                break;
            case 2:
                if (knowFragment == null) {

                    knowFragment = new KnowFragment();
                    transaction.add(R.id.content, knowFragment);
                } else {

                    transaction.show(knowFragment);
                }
                transaction.commit();
//                }

                home_sign.setVisibility(View.VISIBLE);
                home_title.setText(getString(R.string.home_title_real));
                break;
            case 3:
                if (taleFragment == null) {

                    taleFragment = new TaleFragment();
                    transaction.add(R.id.content, taleFragment);
                } else {

                    transaction.show(taleFragment);
                }
                transaction.commit();

                home_sign.setVisibility(View.GONE);
                home_title.setText(getString(R.string.home_title_tale));

                break;

            case 4:
                if (myFragment == null) {

                    myFragment = new MyFragment();
                    transaction.add(R.id.content, myFragment);
                } else {

                    transaction.show(myFragment);
                }
                transaction.commit();

                home_sign.setVisibility(View.GONE);
                home_title.setText(getString(R.string.home_title_my));
                break;



        }

    }

    /**
     * @param index
     */
    private void setImageText(int index) {

        clearSelection();
        switch (index) {
            case 0:
                // 当点击了tab时，改变控件的图片和文字颜色
                verify_image.setImageResource(R.mipmap.home_sj_select);
                verify_text.setTextColor(getResources().getColorStateList(
                       R.color.colorPrimary));
                break;
            case 1:
                sign_image.setImageResource(R.mipmap.home_shop_select);
              sign_text.setTextColor(getResources().getColorStateList(
                        R.color.colorPrimary));
                break;
            case 2:
                video_image.setImageResource(R.mipmap.home_know_select);
                video_text.setTextColor(getResources().getColorStateList(
                        R.color.colorPrimary));
                break;

            case 3:
                flight_image.setImageResource(R.mipmap.home_cq_select);
               flight_text.setTextColor(getResources().getColorStateList(
                        R.color.colorPrimary));

                break;


            case 4:
                account_image.setImageResource(R.mipmap.home_my_select);
               account_text.setTextColor(getResources().getColorStateList(
                        R.color.colorPrimary));

                break;


        }

    }


    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        account_image.setImageResource(R.mipmap.home_my_unselect);
        flight_image.setImageResource(R.mipmap.home_cq_unselect);
        video_image.setImageResource(R.mipmap.home_know_unselect);
        sign_image.setImageResource(R.mipmap.home_shop_unselect);
        verify_image.setImageResource(R.mipmap.home_sj_unselect);

        flight_text.setTextColor(getResources().getColor(
                R.color.unselectTextGray));
        verify_text.setTextColor(getResources().getColor(
                R.color.unselectTextGray));
        sign_text.setTextColor(getResources().getColor(
                R.color.unselectTextGray));
        video_text.setTextColor(getResources().getColor(
                R.color.unselectTextGray));
        account_text.setTextColor(getResources().getColor(
                R.color.unselectTextGray));
  /*      flight_image.setImageResource(R.mipmap.main_fight_no);
   *//*     flight_text.setTextColor(getResources().getColor(
                R.color.main_text));*//*
        verify_image.setImageResource(R.mipmap.main_verify_no);
    *//*    verify_text.setTextColor(getResources().getColor(
                R.color.main_text));*//*
        sign_image.setImageResource(R.mipmap.main_sign_no);
     *//*   sign_text.setTextColor(getResources().getColor(
                R.color.main_text));*//*
        video_image.setImageResource(R.mipmap.main_video_no);
  *//*      video_text.setTextColor(getResources().getColor(
                R.color.main_text));*//*

        account_image.setImageResource(R.mipmap.main_account_no);
  *//*      account_text.setTextColor(getResources().getColor(
                R.color.main_text));*/
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (shopFragment != null) {
            transaction.hide(shopFragment);
        }
        if (realFragment != null) {
            transaction.hide(realFragment);
        }

        if (knowFragment != null) {

            transaction.hide(knowFragment);
        }
        if (taleFragment != null) {
            transaction.hide(taleFragment);
        }
        if (myFragment != null) {
            transaction.hide(myFragment);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        iscycle = savedInstanceState.getBoolean("iscycle");
        chooseIndex = savedInstanceState.getInt("chooseIndex");
        setTabSelection(chooseIndex);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putBoolean("iscycle", true);
        outState.putInt("chooseIndex", chooseIndex);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (iscycle) {
            setImageText(chooseIndex);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 1000) {

                Toast.makeText(HomeActivity.this,getString(R.string.app_back), Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
            } else {
              finish();
            }
        }
        return true;
    }



}
