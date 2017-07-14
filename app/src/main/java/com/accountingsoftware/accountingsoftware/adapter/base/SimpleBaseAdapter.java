package com.accountingsoftware.accountingsoftware.adapter.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public abstract class SimpleBaseAdapter extends BaseAdapter{
    protected Context context = null;
    protected List datas = null;
    protected LayoutInflater layoutInflater = null;

    public SimpleBaseAdapter(Context context,List datas){
        this.context = context;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas!=null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return datas!=null ? datas.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public abstract View getView(int i, View view, ViewGroup viewGroup);
}
