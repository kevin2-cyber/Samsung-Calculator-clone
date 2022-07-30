package com.codelab.samsungcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.codelab.samsungcalculator.databinding.ActivityProfileBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();



    }

    private void logout(View view) {
        Snackbar.make(view,"Logout Successful", Snackbar.LENGTH_LONG).show();
        Toast.makeText(this,"Logout Successful", Toast.LENGTH_LONG).show();
        startActivity(new Intent(this, MainActivity.class));
    }



}
