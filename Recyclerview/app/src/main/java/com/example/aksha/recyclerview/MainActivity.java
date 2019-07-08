package com.example.aksha.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.aksha.recyclerview.adaptor.Categoryadaptor;
import com.example.aksha.recyclerview.pojo.Categorymodel;
import com.example.aksha.recyclerview.retrofit.ApiInterface;
import com.example.aksha.recyclerview.retrofit.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView category_recyclerView;
    private List<Categorymodel> categorymodels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        category_recyclerView = findViewById(R.id.category_recyclerView);
        Category();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        category_recyclerView.setLayoutManager(manager);
    }

    private void Category() {

        ApiInterface apiInterface = Apiclient.getApiClient().create(ApiInterface.class);
        Call<List<Categorymodel>> call = apiInterface.CALL_CATEGORY();

        call.enqueue(new Callback<List<Categorymodel>>() {
            @Override
            public void onResponse(Call<List<Categorymodel>> call, Response<List<Categorymodel>> response) {
                categorymodels = (ArrayList<Categorymodel>) response.body();
                Categoryadaptor categoryadaptor = new Categoryadaptor(getApplicationContext(), (ArrayList<Categorymodel>) categorymodels);
               category_recyclerView.setAdapter(categoryadaptor);
            }

            @Override
            public void onFailure(Call<List<Categorymodel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Something Wrong",Toast.LENGTH_LONG).show();
            }
        });

    }
}
