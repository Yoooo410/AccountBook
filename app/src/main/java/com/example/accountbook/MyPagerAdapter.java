package com.example.accountbook;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;



public class MyPagerAdapter extends PagerAdapter {

    private LayoutInflater inflater;

    private static final int PAGE_NUM = 2;
    private String str;

    public MyPagerAdapter(Context context, String str) {
        super();
        inflater = LayoutInflater.from(context);
        this.str = str;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LinearLayout layout = null;
        if(position == 0){
            layout = (LinearLayout)inflater.inflate(R.layout.list_item, null);
//            TextView text = (TextView)layout.findViewById(R.id.text);
//            text.setText(str);
        }else{
            layout = (LinearLayout)inflater.inflate(R.layout.swip_pager, null);
        }

        container.addView(layout);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public int getCount() {

        return PAGE_NUM;
    }

    @Override
    public boolean isViewFromObject(View view, Object obj) {

        return view.equals(obj);
    }
}
