package com.example.accountbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyFragment extends Fragment {

    public static MyFragment newInstance(int id){
        Fragment fragment = new MyFragment();
        return (MyFragment) fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expense_of_month_page, container, false);

        //動的に変化する値がここに入る
//        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.fragment_main_linearlayout);

        return view;
    }
}
