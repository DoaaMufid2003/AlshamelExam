package com.example.alshamelexam.databaseUser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.alshamelexam.LoginActivity;
import com.example.alshamelexam.R;
import com.example.alshamelexam.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
ActivityRegisterBinding binding;
database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegisterBinding.inflate(getLayoutInflater());
        database=new database(getApplicationContext());
        setContentView(binding.getRoot());
      binding.btnRegistar.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              User user=new User(binding.etName.getText().toString(),binding.etPassword.getText().toString(),binding.etEmail.getText().toString());

                boolean b=  database.insertUser(user);
              Log.d("boolnnn", b+"");
              startActivity(new Intent(getBaseContext(), LoginActivity.class));
                  Log.d("allUser", database.getAllUsers().size()+"");
//            finish();
              }
      });



    }
}