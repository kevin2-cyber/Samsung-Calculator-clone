package com.codelab.samsungcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.codelab.samsungcalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    // viewBinding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.testBtn.setOnClickListener {
            Snackbar.make(this,it,"Login Successful", Snackbar.LENGTH_LONG).show()
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}