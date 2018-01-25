package com.example.sgr.wzd.module.common.home;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sgr.wzd.R;
import com.example.sgr.wzd.app.BaseMvpActivity;
import com.example.sgr.wzd.app.baseLce.BaseLceActivity;
import com.example.sgr.wzd.module.Know.KnowFragment;
import com.example.sgr.wzd.module.My.MyFragment;
import com.example.sgr.wzd.module.Real.RealFragment;
import com.example.sgr.wzd.module.Shop.ShopFragment;
import com.example.sgr.wzd.module.Tale.TaleFragment;
import com.example.sgr.wzd.module.common.CommonPresenter;
import com.example.sgr.wzd.module.common.CommonView;
import com.tz.mvp.framework.support.view.MvpActivity;

import butterknife.OnClick;

public class HomeActivity extends BaseMvpActivity<CommonView,CommonPresenter> implements CommonView {

    private MyFragment myFragment;
    private TaleFragment taleFragment;
    private ShopFragment shopFragment;
    private KnowFragment knowFragment;
    private RealFragment realFragment;


    @InjectView(R.id.verify_layout)
    View verify_layout;


    @InjectView(R.id.sign_layout)
    View sign_layout;

    @InjectView(R.id.video_layout)
    View video_layout;

    @InjectView(R.id.flight_layout)
    View flight_layout;

    @InjectView(R.id.account_layout)
    View account_layout;




    @InjectView(R.id.verify_image)
    ImageView verify_image;

    @InjectView(R.id.flight_image)
    ImageView flight_image;

    @InjectView(R.id.sign_image)
    ImageView sign_image;

    @InjectView(R.id.video_image)
    ImageView video_image;

    @InjectView(R.id.account_image)
    ImageView account_image;

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
                } else {

                    transaction.show(realFragment);
                }
                transaction.commit();

                break;
            case 1:
                if (shopFragment == null) {
                    shopFragment = new shopFragment();

                    transaction.add(R.id.content, shopFragment);
                } else {

                    transaction.show(shopFragment);
                }
                transaction.commit();
                break;
            case 2:
                if (knowFragment == null) {

                    knowFragment = new knowFragment();
                    transaction.add(R.id.content, knowFragment);
                } else {

                    transaction.show(knowFragment);
                }
                transaction.commit();
//                }


                break;
            case 3:
                if (knowFragment == null) {

                    knowFragment = new FlightFragment();
                    transaction.add(R.id.content, knowFragment);
                } else {

                    transaction.show(knowFragment);
                }
                transaction.commit();
                break;

            case 4:
                if (myFragment == null) {

                    myFragment = new myFragment();
                    transaction.add(R.id.content, myFragment);
                } else {

                    transaction.show(myFragment);
                }
                transaction.commit();
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
                verify_image.setImageResource(R.mipmap.main_verify_select);
                verify_text.setTextColor(getResources().getColorStateList(
                        R.color.main_text_select));
                break;
            case 1:
                sign_image.setImageResource(R.mipmap.main_sign_select);
                sign_text.setTextColor(getResources().getColorStateList(
                        R.color.main_text_select));
                break;
            case 2:
                video_image.setImageResource(R.mipmap.main_video_select);
                video_text.setTextColor(getResources().getColorStateList(
                        R.color.main_text_select));
                break;

            case 3:
                flight_image.setImageResource(R.mipmap.main_fight_select);
                flight_text.setTextColor(getResources().getColorStateList(
                        R.color.main_text_select));

                break;


            case 4:
                account_image.setImageResource(R.mipmap.main_account_select);
                account_text.setTextColor(getResources().getColorStateList(
                        R.color.main_text_select));

                break;


        }

    }


    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        flight_image.setImageResource(R.mipmap.main_fight_no);
        flight_text.setTextColor(getResources().getColor(
                R.color.main_text));
        verify_image.setImageResource(R.mipmap.main_verify_no);
        verify_text.setTextColor(getResources().getColor(
                R.color.main_text));
        sign_image.setImageResource(R.mipmap.main_sign_no);
        sign_text.setTextColor(getResources().getColor(
                R.color.main_text));
        video_image.setImageResource(R.mipmap.main_video_no);
        video_text.setTextColor(getResources().getColor(
                R.color.main_text));

        account_image.setImageResource(R.mipmap.main_account_no);
        account_text.setTextColor(getResources().getColor(
                R.color.main_text));
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
        if (knowFragment != null) {
            transaction.hide(knowFragment);
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
    protected void onSaveInstanceState(Bundle outState) {

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

                Toast.makeText(MainActivity.this,getString(R.string.app_back), Toast.LENGTH_SHORT).show();
                firstTime = secondTime;
            } else {
                MyApplication.getInstance().exit();
            }
        }
        return true;
    }



}
