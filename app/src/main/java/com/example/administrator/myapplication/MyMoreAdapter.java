package com.example.administrator.myapplication;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Author:LiaoChengbiao
 * Time:2018/5/9
 * Description:Android中RecyclerView的adapter封装及实现动态加载多布局的功能扩展
 */

public class MyMoreAdapter extends MultiLayoutsBaseAdapter<likeRecommend> {
    public static final int ITEM_HEAD = 0;
    public static final int ITEM_MENU = 1;
    public static final int ITEM_SALE = 2;
    Context context;

    public MyMoreAdapter(Context context, List<likeRecommend> data, int[] layoutIds) {
        super(context, data, layoutIds);
        this.context = context;
    }

    @Override
    public int getItemType(int position) {
        if (position == 0) {
            return ITEM_HEAD;
        } else if (position == 1) {
            return ITEM_MENU;
        } else {
            return ITEM_SALE;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBinds(BaseHolder holder, likeRecommend likeRecommend, int position, int itemType) {

        switch (itemType) {
            case ITEM_HEAD:


                break;
            case ITEM_MENU:
                RecyclerView rl = holder.getView(R.id.rl_recommend);
                LinearLayoutManager manager = new LinearLayoutManager(context);
                manager.setOrientation(LinearLayoutManager.HORIZONTAL);
                rl.setLayoutManager(manager);

                List<com.example.administrator.myapplication.likeRecommend> sendlist = likeRecommend.getSendlist();

                secondadapter adapter = new secondadapter(context, sendlist, R.layout.item_recommend_list_item);
                rl.setAdapter(adapter);

                break;
            case ITEM_SALE:
                ImageView imageView = holder.getView(R.id.img);
                TextView title = holder.getView(R.id.title);
                TextView dec = holder.getView(R.id.dec);

                title.setText(likeRecommend.getTitle());
                dec.setText(likeRecommend.getDec());
                Glide.with(context).load(likeRecommend.getImg()).into(imageView);

                break;
            default:
                break;

        }


    }
}
