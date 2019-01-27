package com.example.dell_pc.techbonatask1app;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit retrofit = null;
    public static String BASE_URL = "http://shdapi.datasciencejournal.xyz/api/";

    public static Retrofit getRetrofit() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
