package com.test.aksha.retrotest;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.test.aksha.retrotest.Adapter.Category;
import com.test.aksha.retrotest.POJO.Category_model;
import com.test.aksha.retrotest.RetrofitInstance.Api;
import com.test.aksha.retrotest.RetrofitInstance.ApiInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Category_model> category_models;
    RecyclerView recycler_data;
    private Category.OnItemClickListener onItemClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recycler_data = findViewById(R.id.recycler_data);
        category_models = new ArrayList<>();

        Api apiService = ApiInstance.getClient().create(Api.class);
        Call<Category_model> call = apiService.GetData("123");
        call.enqueue(new Callback<Category_model>() {
            @Override
            public void onResponse(@NonNull Call<Category_model> call, @NonNull Response<Category_model> response) {
                Log.v("fff", "" + response.body().getSuccess());
                Category category = new Category(response.body().getCategory(), getApplicationContext(), new Category.OnItemClickListener() {
                    @Override
                    public void onItemClick(String CategoryID) {
                        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                        intent.putExtra("category_id", CategoryID);
                        startActivity(intent);
                    }
                });
                recycler_data.setAdapter(category);
            }

            @Override
            public void onFailure(Call<Category_model> call, Throwable t) {

            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler_data.setLayoutManager(manager);


    }
}
