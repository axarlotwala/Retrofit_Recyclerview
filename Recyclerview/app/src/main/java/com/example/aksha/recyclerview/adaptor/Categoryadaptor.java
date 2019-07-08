package com.example.aksha.recyclerview.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aksha.recyclerview.R;
import com.example.aksha.recyclerview.pojo.Categorymodel;

import java.util.ArrayList;
import java.util.List;

public class Categoryadaptor extends RecyclerView.Adapter<Categoryadaptor.ViewHolder> {

    private Context context;
    private ArrayList<Categorymodel> model;


    public Categoryadaptor(Context context, ArrayList<Categorymodel> model) {
        this.context = context;
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(context).load(model.get(position).getCategory_Image()).into(holder.cat_image);
        holder.cat_name.setText(model.get(position).getCategory_Name());

    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView cat_image;
        TextView cat_name;

        public ViewHolder(View itemView) {
            super(itemView);

            cat_image = itemView.findViewById(R.id.cat_image);
            cat_name = itemView.findViewById(R.id.cat_name);
        }
    }
}
