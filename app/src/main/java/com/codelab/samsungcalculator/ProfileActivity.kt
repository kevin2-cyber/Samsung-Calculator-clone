package com.codelab.samsungcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.widget.Toast
import android.content.Intent
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.codelab.samsungcalculator.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(
            layoutInflater
        )
        installSplashScreen().apply {  }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.welcomeBtn.setOnClickListener {
            welcome(it)
        }
    }

    private fun welcome(view: View) {
        Snackbar.make(view, "Welcome", Snackbar.LENGTH_LONG).show()
        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, MainActivity::class.java))
    }
}