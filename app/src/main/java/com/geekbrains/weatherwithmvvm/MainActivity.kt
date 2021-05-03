package com.geekbrains.weatherwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geekbrains.weatherwithmvvm.databinding.MainActivityBinding
import com.geekbrains.weatherwithmvvm.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}