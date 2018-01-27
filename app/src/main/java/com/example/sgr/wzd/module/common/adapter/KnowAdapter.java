 package com.example.sgr.wzd.module.common.adapter;


 import android.view.View;

 import com.chad.library.adapter.base.BaseQuickAdapter;
 import com.example.sgr.wzd.R;
 import com.example.sgr.wzd.model.dbBean.NewsTitle;
 import com.example.sgr.wzd.widget.CommonViewHolder;


 /**
 * Created by Administrator on 2017/8/24.
 */


public class KnowAdapter extends BaseQuickAdapter<NewsTitle,CommonViewHolder> implements BaseQuickAdapter.OnItemChildClickListener,BaseQuickAdapter.OnItemClickListener{
    public KnowAdapter() {
        super(R.layout.item_news);
    }
    @Override
    protected void convert(CommonViewHolder baseViewHolder, NewsTitle personItem) {
//        baseViewHolder.setText(R.id.product_name,personItem.getName());
       /* baseViewHolder.setText(R.id.title, personItem.getTitle());
        baseViewHolder.setText(R.id.c_down, personItem.getC_down());*/

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}