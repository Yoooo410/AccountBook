package com.example.accountbook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class MyCategoryAdapter extends RecyclerView.Adapter<MyCategoryAdapter.ViewHolder> {

    private ArrayList<Category> category;
    private Context context;

    public MyCategoryAdapter(Context context, ArrayList<Category> category){
        this.category = category;
        this.context = context;
    }

    @Override
    public MyCategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyCategoryAdapter.ViewHolder holder, int position) {
        holder.categoryTextView.setText(category.get(position).getCategoryName());
        Picasso.with(context).load(category.get(position).getCategoryIcon()).resize(240,240).into(holder.categoryImageView);
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView categoryTextView;
        private ImageView categoryImageView;

        public ViewHolder(View view){
            super(view);
            categoryTextView = (TextView)view.findViewById(R.id.categoryTextView);
            categoryImageView = (ImageView) view.findViewById(R.id.categoryImageView);
        }
    }
}
