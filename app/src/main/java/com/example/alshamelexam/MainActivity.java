package com.example.alshamelexam;



import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alshamelexam.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("sp", MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("name", binding.etName.getText().toString());
                editor.putString("age", binding.etAge.getText().toString());
                editor.apply();
                startActivity(new Intent(getBaseContext(),MainActivity2.class));
            }
        });

    }
}