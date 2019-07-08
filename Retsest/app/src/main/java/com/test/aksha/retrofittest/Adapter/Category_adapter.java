package com.test.aksha.retrofittest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.test.aksha.retrofittest.Categorydetail_activity;
import com.test.aksha.retrofittest.Model.Category_model;
import com.test.aksha.retrofittest.R;

import java.util.List;


public class Category_adapter extends RecyclerView.Adapter<Category_adapter.ViewHolder> {

    private Context context;
    private List<Category_model.Category> category_models;

    public Category_adapter(Context context, List<Category_model.Category> category_models) {
        this.context = context;
        this.category_models = category_models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.category_name.setText(category_models.get(position).getCategory_name());
        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),Categorydetail_activity.class);
                intent.putExtra("category_id",category_models.get(position).getCategory_id());
                Log.v("category_id",category_models.get(position).getCategory_id());
                v.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return category_models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

       private LinearLayout linear;
       private TextView category_name;

        public ViewHolder(View itemView) {
            super(itemView);

            linear = itemView.findViewById(R.id.linear);
            category_name = itemView.findViewById(R.id.category_name);
        }
    }

}
