package com.example.proyecto_final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MySplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.SplashTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_splash_screen)
    }
}