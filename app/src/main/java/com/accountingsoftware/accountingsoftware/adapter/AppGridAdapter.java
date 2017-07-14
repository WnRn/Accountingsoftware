package com.accountingsoftware.accountingsoftware.adapter;

import android.content.Context;

import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.accountingsoftware.accountingsoftware.R;

/**
 * Created by Administrator on 2017/7/14.
 *
 */

//自定义适配器继承BaseAdapter
public class AppGridAdapter extends BaseAdapter{
    private Context context;
    private Integer[] imgInteger = {
            R.drawable.grid_payout,
            R.drawable.grid_bill,
            R.drawable.grid_report,
            R.drawable.grid_account_book,
            R.drawable.grid_category,
            R.drawable.grid_user,
    };
    private String[] imgString = new String[6];



    public AppGridAdapter(Context context){
        this.context = context;
        imgString[0] = context.getString(R.string.grid_payout_add);//记录消费
        imgString[1] = context.getString(R.string.grid_payout_manage);//查询消费
        imgString[2] = context.getString(R.string.grid_account_manage);//账本管理
        imgString[3] = context.getString(R.string.grid_statistics_manage);//统计管理
        imgString[4] = context.getString(R.string.grid_category_manage);//类别管理
        imgString[5] = context.getString(R.string.grid_user_manage);//人员管理
    }

    public int getCount() {
        return imgString.length;
    }

    @Override
    public Object getItem(int i) {
        return imgString[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.main_body_item,null);
            holder = new Holder();
            holder.icon_iv = view.findViewById(R.id.main_body_item_icon_iv);
            holder.name_tv = view.findViewById(R.id.main_body_item_name_tv);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }

        holder.icon_iv.setImageResource(imgInteger[i]);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(80,80);
        holder.icon_iv.setLayoutParams(layoutParams);
        holder.icon_iv.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.name_tv.setText(imgString[i]);

        return view;
    }
    private class Holder{
        ImageView icon_iv;
        TextView name_tv;
    }
}
