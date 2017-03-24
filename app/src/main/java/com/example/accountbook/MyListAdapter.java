//package com.example.accountbook;
//
//import android.content.Context;
//import android.support.v4.view.ViewPager;
//import android.view.Display;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.widget.ArrayAdapter;
//
//
//public class MyListAdapter extends ArrayAdapter<String> {
//
//
//    private LayoutInflater inflater = null;
//    private static final float BUTTON_WIDTH_DP = 70f;
//    private int margin;
//
//    public MyListAdapter(Context context, int resource, String[] items) {
//        super(context, resource,items);
//        inflater = LayoutInflater.from(context);
//
//        //ページ2のRelativeLayoutの幅を計算してmarginへ格納する。
//        float density = getContext().getResources().getDisplayMetrics().density;
//        int buttonWidthPX = (int) (BUTTON_WIDTH_DP * density + 0.5f);
//
//        WindowManager wm = (WindowManager)getContext().getSystemService(getContext().WINDOW_SERVICE);
//        Display dp = wm.getDefaultDisplay();
//        margin = dp.getWidth() - buttonWidthPX;
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if(convertView == null){
//            convertView = inflater.inflate(R.layout.view_pager,null);
//        }
//
//        ViewPager viewPager = (ViewPager)convertView.findViewById(R.id.viewpager);
//        viewPager.setPageMargin(-margin);
//        MyPagerAdapter adapter = new MyPagerAdapter(getContext(),getItem(position));
//        viewPager.setAdapter(adapter);
//
//        return convertView;
//    }
//}

