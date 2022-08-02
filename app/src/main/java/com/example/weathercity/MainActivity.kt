package com.example.weathercity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weathercity.fragments.MainFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_box, MainFragment.newInstance())
            .commit()
    }
}