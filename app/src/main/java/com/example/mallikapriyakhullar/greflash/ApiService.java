package com.example.mallikapriyakhullar.greflash;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mallikapriyakhullar on 21/11/17.
 */
public interface ApiService {

    @GET("78LK.json")
    Call<Wordlist> getWords();
}