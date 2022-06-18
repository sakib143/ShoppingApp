package com.example.shopingapp.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shopingapp.R
import com.example.shopingapp.ui.home.HomeActivity
import com.example.shopingapp.utils.clearStack

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val homeIntent = Intent(this@SplashActivity, HomeActivity::class.java)
        homeIntent.clearStack()
        startActivity(homeIntent)
        this.overridePendingTransition(0, 0)

    }

}