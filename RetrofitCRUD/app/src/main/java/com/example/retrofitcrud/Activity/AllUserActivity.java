package com.example.retrofitcrud.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitcrud.Adapter.UserAdapter;
import com.example.retrofitcrud.Model.UserModel;
import com.example.retrofitcrud.R;
import com.example.retrofitcrud.Retrofit.RetrofitClient;
import com.example.retrofitcrud.Retrofit.RetrofitInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllUserActivity extends AppCompatActivity {


    private RecyclerView user_list;
    private List<UserModel> userModels;
    private TextView tv_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user);

        user_list = findViewById(R.id.user_list);
        tv_upload = findViewById(R.id.tv_upload);
        userModels = new ArrayList<>();
        GetUSer();

        tv_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AllUserActivity.this,ProfileUploadActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void GetUSer(){

        RetrofitInterface retrofitInterface = RetrofitClient.retrofitClient().create(RetrofitInterface.class);

        Call<List<UserModel>> listCall = retrofitInterface.LIST_CALL();

        listCall.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {

                userModels = response.body();

                LinearLayoutManager layoutManager = new LinearLayoutManager(AllUserActivity.this);
                user_list.setLayoutManager(layoutManager);

                UserAdapter userAdapter  = new UserAdapter(AllUserActivity.this,userModels);
                user_list.setAdapter(userAdapter);

                userAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {

                Toast.makeText(AllUserActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
