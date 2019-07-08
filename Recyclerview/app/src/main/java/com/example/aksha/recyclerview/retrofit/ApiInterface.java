package com.example.aksha.recyclerview.retrofit;

import com.example.aksha.recyclerview.pojo.Categorymodel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("s0q2g")
    Call<List<Categorymodel>> CALL_CATEGORY();
}
