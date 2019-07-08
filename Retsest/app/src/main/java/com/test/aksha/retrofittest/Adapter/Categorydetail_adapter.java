package com.test.aksha.retrofittest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.aksha.retrofittest.Model.Category_model;
import com.test.aksha.retrofittest.Model.Categorydetail_model;
import com.test.aksha.retrofittest.R;

import java.util.List;

public class Categorydetail_adapter extends RecyclerView.Adapter<Categorydetail_adapter.ViewHolder> {

    private Context context;
    private List<Categorydetail_model.Category> list;

    public Categorydetail_adapter(Context context, List<Categorydetail_model.Category> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.v("ddddd", "" + list.get(position).getSite_name());
        Glide.with(context).load(list.get(position).getSite_icon()).into(holder.site_image);
        holder.site_name.setText(list.get(position).getSite_url());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView site_image;
        TextView site_name;

        public ViewHolder(View itemView) {
            super(itemView);
            site_name = itemView.findViewById(R.id.site_name);
            site_image = itemView.findViewById(R.id.site_image);
        }
    }
}
