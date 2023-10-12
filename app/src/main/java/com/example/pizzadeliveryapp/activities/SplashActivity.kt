package com.example.pizzadeliveryapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.pizzadeliveryapp.R

class SplashActivity : AppCompatActivity() {
    private val SPLASH_TIMER: Long = 3000 // 3000 milliseconds, which is 3 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, GetStartedActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMER)
    }
}
