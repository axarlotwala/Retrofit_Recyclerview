package com.example.retrofitcrud.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.retrofitcrud.R;
import com.example.retrofitcrud.ResponseModel.LoginResponse;
import com.example.retrofitcrud.Retrofit.RetrofitClient;
import com.example.retrofitcrud.Retrofit.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText user_email,user_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = user_email.getText().toString().trim();
                String password = user_password.getText().toString().trim();

                if (email.isEmpty()){
                    user_email.setError("Email Address Require");
                    user_email.requestFocus();
                    return;
                }

                if (password.isEmpty()){
                    user_password.setError("Password Require");
                    user_password.requestFocus();
                    return;
                }


                RetrofitInterface retrofitInterface = RetrofitClient.retrofitClient().create(RetrofitInterface.class);
                Call<LoginResponse> loginResponseCall = retrofitInterface.LOGIN_RESPONSE_CALL(email,password);

                loginResponseCall.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        LoginResponse loginResponse = response.body();
                        if (loginResponse.getError() == false) {
                            Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                            Log.d("Success", "" + loginResponse);
                            Intent intent = new Intent(LoginActivity.this,AllUserActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            onStop();
                            Toast.makeText(LoginActivity.this,loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("Throw",""+t.getMessage());

                    }
                });

            }
        });


    }
}
