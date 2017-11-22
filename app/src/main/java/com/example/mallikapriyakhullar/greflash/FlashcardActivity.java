package com.example.mallikapriyakhullar.greflash;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlashcardActivity extends AppCompatActivity {
    private static ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
//        init();
        ApiService api = RetrofitClient.getApiService();


        Call<Wordlist> call = api.getWords();

        call.enqueue(new Callback<Wordlist>() {
            @Override
            public void onResponse(Call<Wordlist> call, Response<Wordlist> response) {
                Log.d("RESPONSE", response.isSuccessful() + response.raw().toString());

                if(response.isSuccessful()) {

                    ArrayList<WordModel> words = response.body().getWords();

                    mPager = findViewById(R.id.pager);
                    mPager.setAdapter(new ViewPagerAdapter(FlashcardActivity.this, words));
                }
            }

            @Override
            public void onFailure(Call<Wordlist> call, Throwable t) {
                Log.d("RESPONSE", t.getLocalizedMessage());
                //show some dialog
            }
        });

}
}
