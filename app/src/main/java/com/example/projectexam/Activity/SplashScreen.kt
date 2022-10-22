package com.example.projectexam.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.projectexam.R

class SplashScreen : AppCompatActivity() {

    private val splashtime:Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, LoginScreen::class.java))
            finish()
        }, splashtime)
    }
}