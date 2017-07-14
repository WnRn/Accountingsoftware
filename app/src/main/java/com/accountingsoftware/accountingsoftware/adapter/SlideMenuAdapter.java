package com.accountingsoftware.accountingsoftware.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.accountingsoftware.accountingsoftware.R;
import com.accountingsoftware.accountingsoftware.adapter.base.SimpleBaseAdapter;
import com.accountingsoftware.accountingsoftware.view.SlideMenuItem;

import java.util.List;

/**
 * Created by Administrator on 2017/7/14.
 */
public class SlideMenuAdapter extends SimpleBaseAdapter{




    public SlideMenuAdapter(Context context,List list){
      super(context,list);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.slide_menu_list_item,null);
            holder = new Holder();
            holder.menu_name_tv = view.findViewById(R.id.slide_menu_list_item_tv);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        SlideMenuItem item = (SlideMenuItem) datas.get(i);
        holder.menu_name_tv.setText(item.getTitle());

        return view;
    }
    private class Holder{
        TextView menu_name_tv;
    }

}
