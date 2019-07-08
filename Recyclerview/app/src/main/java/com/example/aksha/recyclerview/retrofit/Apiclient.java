package com.example.aksha.recyclerview.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {

    // category api =  https://api.myjson.com/bins/s0q2g

    public static final String BASE_URL  = "https://api.myjson.com/bins/";
    public static Retrofit retrofit = null;

    public static Retrofit getApiClient(){
        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
