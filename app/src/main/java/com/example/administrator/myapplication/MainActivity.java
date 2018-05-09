package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
*@data:2018/5/9
*@description:这是学习这位大神博客https://wangyantao.github.io/  参考写的例子
*/
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rl_test);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initData() {
        List<likeRecommend> likeRecommends2=new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            likeRecommend bean2=new likeRecommend();
            bean2.setDec("喜欢就来这家吧"+i);
            bean2.setImg("http://images.shxtravel.com/upload/rout/201203/91cb0a84e10e21e31aa2b0e9c0c98cd7_1332230346.jpg");
            bean2.setTitle("爱上住酒店"+i);
            likeRecommends2.add(bean2);
        }

        List<likeRecommend> likeRecommends=new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            likeRecommend bean1=new likeRecommend();
            bean1.setDec("这是一家最好的酒店"+i);
            bean1.setImg("http://p0.so.qhimgs1.com/t0145f1e537d80c5c6a.jpg");
            bean1.setTitle("张家界之旅"+i);
            likeRecommends.add(bean1);
            bean1.setSendlist(likeRecommends2);
        }
        int []layoutIds = new int[]{R.layout.item_head, R.layout.item_recomend, R.layout.item_sale};

        //加载多布局时使用
        MyMoreAdapter adapter=new MyMoreAdapter(this,likeRecommends,layoutIds);
        //加载单一布局使用
//        Myadapter adapter = new Myadapter(this,likeRecommends,R.layout.item_sale);
        recyclerView.setAdapter(adapter);
    }
}
