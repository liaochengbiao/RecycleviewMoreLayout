package com.example.administrator.myapplication;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Author:LiaoChengbiao
 * Time:2018/5/9
 * Description:普通单一用形式
 */

public class secondadapter extends BaseAdapter<likeRecommend> {
    Context context;
    public secondadapter(Context context, List<likeRecommend> data, int layoutId) {
        super(context, data, layoutId);
        this.context=context;
    }

    @Override
    public void onBind(BaseHolder holder, likeRecommend likeRecommend, int position) {
        String title1 = likeRecommend.getTitle();
        String img = likeRecommend.getImg();
        String dec1 = likeRecommend.getDec();
        ImageView imageView = holder.getView(R.id.img);
        TextView title = holder.getView(R.id.title);
        TextView dec = holder.getView(R.id.dec);

        title.setText(title1);
        dec.setText(dec1);
        Glide.with(context).load(img).into(imageView);
    }
}
