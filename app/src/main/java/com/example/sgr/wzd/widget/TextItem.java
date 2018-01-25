package com.example.sgr.wzd.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sgr.wzd.R;

/**
 * Data：2018/1/25/025-11:40
 * By  沈国荣
 * Description:自定义封装一个item 左边一个个textview，右边一个textView或者image加箭头
 */
public class TextItem extends RelativeLayout {
    private TextView LeftTextView,RightTextView;
    private ImageView RightImage,arrow;
    private View lineView;
    private int line_visbile,right_img_visbile,right_text_visbile;
    private String left_text,right_text;
    public TextItem(Context context) {
        super(context);
    }

    public TextItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化布局
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_text,this);
        //初始化控件
        RightImage=(ImageView) findViewById(R.id.right_imageView);
        LeftTextView=(TextView)findViewById(R.id.item_text_left);
        RightTextView=(TextView)findViewById(R.id.item_text_right);
        lineView=(View)findViewById(R.id.item_line);
        //初始化获得数据
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.TextItem);
        line_visbile=array.getInt(R.styleable.TextItem_line_visbile,View.VISIBLE);
        right_img_visbile=array.getInt(R.styleable.TextItem_right_img_visbile,View.GONE);
        right_text_visbile=array.getInt(R.styleable.TextItem_right_text_visbile,View.VISIBLE);
        left_text=array.getString(R.styleable.TextItem_left_text);
        right_text=array.getString(R.styleable.TextItem_right_text);
        array.recycle();
        //绑定数据
        if(line_visbile==View.VISIBLE){
            lineView.setVisibility(View.VISIBLE);
        }else{
            lineView.setVisibility(View.GONE);
        }

        if(right_img_visbile==View.VISIBLE){
            RightImage.setVisibility(View.VISIBLE);
        }else{
            RightImage.setVisibility(View.GONE);
        }

        if(right_text_visbile==View.VISIBLE){
            RightTextView.setVisibility(View.VISIBLE);
        }else{
            RightTextView.setVisibility(View.GONE);
        }

        RightTextView.setText(right_text);
        LeftTextView.setText(left_text);
    }

    /**
     * 设置右边text文字
     */
    public  void setRightText(String text){
        RightTextView.setText(text);
    }
    /**
     * 设置左边边text文字
     */
    public  void setLeftText(String text){
        LeftTextView.setText(text);
    }

    /**
     * 获得右边的imageView
     * @return
     */
    public ImageView getRightImage(){
        return RightImage;
    }


}
