package com.example.gads2020.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import com.example.gads2020.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBarLessThanSixteen()
        setContentView(R.layout.activity_splash)
        hidesStatusBarApiSixteenandMore()
        navigateAfterDelayToNewActivity()

    }

    private fun navigateAfterDelayToNewActivity() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, 2000)
    }

    private fun hideStatusBarLessThanSixteen() {
        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }

    private fun hidesStatusBarApiSixteenandMore() {
        if (Build.VERSION.SDK_INT >= 16) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
        }
    }
}