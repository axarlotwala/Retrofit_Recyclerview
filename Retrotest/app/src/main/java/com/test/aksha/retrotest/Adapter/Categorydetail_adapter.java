package com.test.aksha.retrotest.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.aksha.retrotest.POJO.Categorydetail_model;
import com.test.aksha.retrotest.R;

import org.w3c.dom.Text;

import java.util.List;

public class Categorydetail_adapter extends RecyclerView.Adapter<Categorydetail_adapter.ViewHolder> {

    private Context context;
    private List<Categorydetail_model.Category> categorydetail_models;

    public Categorydetail_adapter(Context context, List<Categorydetail_model.Category> categorydetail_models) {
        this.context = context;
        this.categorydetail_models = categorydetail_models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.url.setText(categorydetail_models.get(position).getSite_url());
        Glide.with(context).load(categorydetail_models.get(position).getSite_icon()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return categorydetail_models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView url;
        private ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);

            url = itemView.findViewById(R.id.url);
            icon = itemView.findViewById(R.id.icon);

        }
    }
}
