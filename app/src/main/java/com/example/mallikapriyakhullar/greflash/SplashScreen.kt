package com.example.mallikapriyakhullar.greflash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*
import retrofit2.Call

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        btn_enter.setOnClickListener {
            val intent = Intent(this@SplashScreen, FlashcardActivity::class.java)
            intent.putExtra("key", "Kotlin")
            startActivity(intent)
        }
    }
}
