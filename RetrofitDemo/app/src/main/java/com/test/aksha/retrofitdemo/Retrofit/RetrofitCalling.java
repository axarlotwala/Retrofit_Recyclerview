package com.test.aksha.retrofitdemo.Retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.aksha.retrofitdemo.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCalling {

    private static final String BASE_URL = "http://192.168.0.103/CafeResturant/Customer/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }


}
