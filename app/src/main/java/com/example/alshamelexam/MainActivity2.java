package com.example.alshamelexam;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alshamelexam.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPreferences=getSharedPreferences("sp", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        binding.textView.setText(sharedPreferences.getString("name", ""));
        binding.textView2.setText(sharedPreferences.getString("age", ""));


    }
}