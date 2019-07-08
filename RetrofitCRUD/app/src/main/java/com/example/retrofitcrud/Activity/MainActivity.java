package com.example.retrofitcrud.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofitcrud.R;
import com.example.retrofitcrud.ResponseModel.RegisterResponse;
import com.example.retrofitcrud.Retrofit.RetrofitClient;
import com.example.retrofitcrud.Retrofit.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextInputEditText stud_name,stud_email,stud_city,stud_phone;
    RadioGroup stud_div,gender;
    Button btn_register;
    RadioButton radioButton;
    TextView login_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stud_name = findViewById(R.id.stud_name);
        stud_email = findViewById(R.id.stud_email);
        stud_city = findViewById(R.id.stud_city);
        stud_phone = findViewById(R.id.stud_phone);
        stud_div = findViewById(R.id.stud_div);
        gender = findViewById(R.id.gender);
        btn_register = findViewById(R.id.btn_register);
        login_tv = findViewById(R.id.login_tv);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateUser();
            }
        });

        login_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });
    }

    private void CreateUser() {

        String name =  stud_name.getText().toString().trim();
        String email = stud_email.getText().toString().trim();
        String city = stud_city.getText().toString().trim();
        String phone = stud_phone.getText().toString().trim();

        int id = stud_div.getCheckedRadioButtonId();
        radioButton = findViewById(id);
        String div = radioButton.getText().toString();

        int choice = gender.getCheckedRadioButtonId();
        radioButton = findViewById(choice);
        String gen = radioButton.getText().toString();



        if (name.isEmpty()) {
            stud_name.setError("Name Is Require");
            stud_name.requestFocus();
            return;
        }

        if (email.isEmpty()) {

            stud_email.setError("Email Is Require");
            stud_email.requestFocus();
            return;
        }

        if (city.isEmpty()) {
            stud_city.setError("Enter Your City");
            stud_city.requestFocus();
            return;
        }

        if (phone.isEmpty()) {
            stud_phone.setError("Kindly Require Your PhoneNo");
            stud_phone.requestFocus();
            return;

        }

        RetrofitInterface retrofitInterface = RetrofitClient.retrofitClient().create(RetrofitInterface.class);

        Call<RegisterResponse> call = retrofitInterface.REGISTER_RESPONSE_CALL(name,email,city,phone,div,gen);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                RegisterResponse registerResponse = response.body();

                Toast.makeText(MainActivity.this,registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
