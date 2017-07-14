package com.accountingsoftware.accountingsoftware.view;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.accountingsoftware.accountingsoftware.R;
import com.accountingsoftware.accountingsoftware.adapter.SlideMenuAdapter;
import com.accountingsoftware.accountingsoftware.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/13.
 * 滑动菜单
 */

public class SlideMenuView {
    private Activity activity;//哪个Activity调用就把哪个Activity传过来
    private List<SlideMenuItem> menuList;
    private boolean isClosed;
    private RelativeLayout bottomBoxLayout;


    public SlideMenuView(Activity activity) {
        this.activity = activity;
        initVariable();
        initView();
        initListeners();//初始化监听

    }

    //初始化变量
    public void initVariable() {
        menuList = new ArrayList<>();
        isClosed = true;

    }

    //初始化控件
    public void initView() {
        bottomBoxLayout = activity.findViewById(R.id.include_bottom);

    }

    //初始化监听
    public void initListeners() {
        bottomBoxLayout.setOnClickListener(new OnSlideMenuClick());

    }

    //监听菜单的点击事件
    private class OnSlideMenuClick implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            toggle();
        }
    }

    //打开菜单
    private void open(){

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.
                LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.BELOW,R.id.include_title);
        bottomBoxLayout.setLayoutParams(layoutParams);
        isClosed = false;
    }

    //关闭菜单
    private void close(){
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.
                //dip2px(Context context, float dipValue)
                LayoutParams( RelativeLayout.LayoutParams.MATCH_PARENT, new DisplayUtil().dip2px(activity,68));
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        bottomBoxLayout.setLayoutParams(layoutParams);
        isClosed = true;
    }

    //开关方法 控制打开、关闭
        private void  toggle(){
            if(isClosed){
                open();
            }else{
                close();
            }
        }

    //添加菜单项
    public void add(SlideMenuItem slideMenuItem){
        menuList.add(slideMenuItem);
    }

    //绑定数据原
    public void bundList(){
        SlideMenuAdapter adapter = new SlideMenuAdapter(activity,menuList);
        ListView listView = (ListView) activity.findViewById(R.id.slide_list_lv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnSlideMenuItemClick());
    }

    //点击事件写到一个方法里没有直接new
    public class OnSlideMenuItemClick implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    }
}
