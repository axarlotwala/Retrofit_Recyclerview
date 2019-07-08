package com.test.aksha.retrofittest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.test.aksha.retrofittest.Adapter.Categorydetail_adapter;
import com.test.aksha.retrofittest.Model.Categorydetail_model;
import com.test.aksha.retrofittest.Retrofit.Api;
import com.test.aksha.retrofittest.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Categorydetail_activity extends AppCompatActivity {

    RecyclerView sub_cat;

    private List<Categorydetail_model> models;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorydetail);

        sub_cat = findViewById(R.id.sub_cat);

        Intent intent = getIntent();

        models = new ArrayList<>();

        Api api = ApiInterface.getClient().create(Api.class);

        Call<Categorydetail_model> call = api.GetSingleData("123",intent.getStringExtra("category_id"));

        call.enqueue(new Callback<Categorydetail_model>() {
            @Override
            public void onResponse(Call<Categorydetail_model> call, Response<Categorydetail_model> response) {

                Log.v("successss",""+response.body().getSuccess());
                Log.v("successss-",""+response.body().getCategory().size());
                Categorydetail_adapter adapter = new Categorydetail_adapter(getApplicationContext(),response.body().getCategory());
                sub_cat.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Categorydetail_model> call, Throwable t) {

                Toast.makeText(Categorydetail_activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager manager = new LinearLayoutManager(this);
        sub_cat.setLayoutManager(manager);

    }
}
