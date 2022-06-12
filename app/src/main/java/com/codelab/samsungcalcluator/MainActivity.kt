package com.codelab.samsungcalcluator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codelab.samsungcalcluator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()
    }
}