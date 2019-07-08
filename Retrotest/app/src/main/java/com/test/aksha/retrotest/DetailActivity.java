package com.test.aksha.retrotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.test.aksha.retrotest.Adapter.Categorydetail_adapter;
import com.test.aksha.retrotest.POJO.Categorydetail_model;
import com.test.aksha.retrotest.RetrofitInstance.Api;
import com.test.aksha.retrotest.RetrofitInstance.ApiInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    List<Categorydetail_model> categorydetail_models;
    RecyclerView product_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        product_detail = findViewById(R.id.product_detail);

        Intent intent = getIntent();

        categorydetail_models = new ArrayList<>();

        Api api = ApiInstance.getClient().create(Api.class);

        Call<Categorydetail_model> call = api.GetSingleProductDetails("123",intent.getStringExtra("category_id"));

        call.enqueue(new Callback<Categorydetail_model>() {
            @Override
            public void onResponse(Call<Categorydetail_model> call, Response<Categorydetail_model> response) {
                Log.v("onsuccess",""+response.body().getSuccess());
                Log.v("onsuccess",""+response.body().getSuccess());
                Categorydetail_adapter adapter = new Categorydetail_adapter(getApplicationContext(),response.body().getCategory());
                product_detail.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Categorydetail_model> call, Throwable t) {
                Toast.makeText(DetailActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this);
        product_detail.setLayoutManager(manager);
    }
}
