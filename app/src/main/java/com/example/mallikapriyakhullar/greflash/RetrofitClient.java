package com.example.mallikapriyakhullar.greflash;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mallikapriyakhullar on 21/11/17.
 */

public class RetrofitClient {

    private static final String ROOT_URL = "https://www.jasonbase.com/things/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}