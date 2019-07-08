package com.test.aksha.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.test.aksha.retrofittest.Adapter.Category_adapter;
import com.test.aksha.retrofittest.Model.Category_model;
import com.test.aksha.retrofittest.Retrofit.Api;
import com.test.aksha.retrofittest.Retrofit.ApiInterface;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView category;

    private List<Category_model> category_models;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        category = findViewById(R.id.category);

        category_models = new ArrayList<>();

        Api api = ApiInterface.getClient().create(Api.class);

        Call<Category_model> modelCall = api.GetData("123");

        modelCall.enqueue(new Callback<Category_model>() {
            @Override
            public void onResponse(Call<Category_model> call, Response<Category_model> response) {


                Category_adapter category_adapter = new Category_adapter(getApplicationContext(),response.body().getCategory());
                category.setAdapter(category_adapter);
            }

            @Override
            public void onFailure(Call<Category_model> call, Throwable t) {

                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });



        LinearLayoutManager manager = new LinearLayoutManager(this);
        category.setLayoutManager(manager);

    }
}
