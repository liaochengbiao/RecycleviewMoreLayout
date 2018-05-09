package com.example.administrator.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Author:LiaoChengbiao
 * Time:2018/5/9
 * Description:描述
 */

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseHolder> {
    Context context;
    List<T> data;//引入泛型
    int []layoutIds;//布局资源Id数组layoutIds中
    public BaseAdapter(Context context, List<T> data, int layoutId) {
        this.context = context;
        this.data = data;
        //不使用多布局时的构造函数，将layoutId放到布局资源Id数组layoutIds中
        this.layoutIds = new int[]{layoutId};
    }
    //使用多布局时的构造函数，可以接收传入的布局资源Id数组
    public BaseAdapter(Context context, List<T> data, int[] layoutIds) {
        this.context = context;
        this.data = data;
        this.layoutIds = layoutIds;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    public List<T> getData() {
        return this.data;
    }
    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //根据viewType从布局资源数组中加载指定的布局
        //1.当不需要加载多布局时，子类继承BaseAdapter，不用覆写getItemViewType()
        //此时，viewType值默认为0；
        //2.当需要加载多布局时，子类继承MultiLayoutsBaseAdapter，需要覆写getItemViewType()
        //此时，viewType值为子类adapter指定的值；
        return BaseHolder.getHolder(context, parent, layoutIds[viewType]);
    }
    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        //调用由子类实现的抽象方法，将操作下放到子类中
        onBind(holder, data.get(position), position);
    }
    //抽象方法，让子类继承实现
    public abstract void onBind(BaseHolder holder, T t, int position);
}
