package com.example.accountbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MyCategoryAdapter extends RecyclerView.Adapter<MyCategoryAdapter.ViewHolder> {

    private int[] categoryText;
    private int[] categoryImage;

    public  static class ViewHolder extends RecyclerView.ViewHolder{

        public RelativeLayout categoryImage;

        public ViewHolder(RelativeLayout v){
            super(v);
            categoryImage = v;
        }
    }

//    public TextView categoryTextView;
//    public ImageView categoryImageView;

    public MyCategoryAdapter(int[] categoryText, int[] categoryImage) {
        categoryText = categoryText;
        categoryImage = categoryImage;
    }

    @Override
    public MyCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_layout,null);

        ViewHolder vh = new ViewHolder((RelativeLayout) v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.categoryImage.setVisibility(categoryText[position]);
    }

    @Override
    public int getItemCount() {
        return categoryText.length;
    }
}
