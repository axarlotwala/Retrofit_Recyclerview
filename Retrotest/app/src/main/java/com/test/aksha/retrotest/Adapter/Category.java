package com.test.aksha.retrotest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.test.aksha.retrotest.DetailActivity;
import com.test.aksha.retrotest.MainActivity;
import com.test.aksha.retrotest.POJO.Category_model;
import com.test.aksha.retrotest.R;

import java.util.List;

import retrofit2.Callback;

public class Category extends RecyclerView.Adapter<Category.ViewHolder> {


    private List<Category_model.Category> category_models;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public Category(List<Category_model.Category> category_models, Context context, OnItemClickListener onItemClickListener) {
        this.category_models = category_models;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.category_name.setText(category_models.get(position).getCategory_name());
        holder.layout_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(category_models.get(position).getCategory_id());
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra("category_id", category_models.get(position).getCategory_id());
//                Log.v("id", category_models.get(position).getCategory_id());
//                Toast.makeText(context, category_models.get(position).getCategory_name(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return category_models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView category_name;
        LinearLayout layout_click;


        public ViewHolder(View itemView) {
            super(itemView);

            category_name = itemView.findViewById(R.id.category_name);
            layout_click = itemView.findViewById(R.id.layout_click);

        }
    }

    public interface OnItemClickListener {
        void onItemClick(String CategoryID);
    }
}
