package com.example.gads2020.ui.activity

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.gads2020.R
import com.example.gads2020.ui.fragments.FirstFragment
import com.example.gads2020.ui.fragments.SecondFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mainViewPager : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideStatusBarLessThanSixteen()
        setContentView(R.layout.activity_main)
        hidesStatusBarApiSixteenandMore()
        mainViewPager = findViewById(R.id.mainViewPager)
        val pagerAdapter = MultiScreensPagerAdapter(supportFragmentManager)
        mainViewPager.adapter = pagerAdapter
        tabLayoutMain.setupWithViewPager(mainViewPager)
        navigateToFormTxtVw.setOnClickListener(this)
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

    class MultiScreensPagerAdapter(val fm : FragmentManager) :
        FragmentStatePagerAdapter(fm) {
        override fun getCount(): Int = 2


        override fun getItem(position: Int): Fragment {
            return when(position){
                0 -> FirstFragment()
                else -> SecondFragment()
            }
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                1 -> "Learning Leaders"
                else -> "Skill IQ Leaders"
            }
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
           if(p0.id == R.id.navigateToFormTxtVw){
              startActivity(Intent(this, FormActivity::class.java))
           }
        }
    }
}