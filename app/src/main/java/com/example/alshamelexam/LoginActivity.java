package com.example.alshamelexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alshamelexam.database.Database;
import com.example.alshamelexam.databaseUser.AllUsersActivity;
import com.example.alshamelexam.databaseUser.RegisterActivity;
import com.example.alshamelexam.databaseUser.database;
import com.example.alshamelexam.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
ActivityLoginBinding binding;
    com.example.alshamelexam.databaseUser.database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       database=new database(getApplicationContext());
        binding.btnRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), RegisterActivity.class));
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean bool=  database.isCredentialsValid(binding.editTextTextEmailAddress.getText().toString(), binding.editTextTextPassword.getText().toString());
              if (bool){
                  startActivity(new Intent(getBaseContext(), AllUsersActivity.class));
              }else {
                  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LoginActivity.this);
                  alertDialogBuilder.setTitle("Un Authentaction");
                  alertDialogBuilder.setMessage("The User Not found");
                  alertDialogBuilder.setCancelable(false);
                  alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          // Your action when OK button is clicked
                          dialog.dismiss(); // Close the dialog
                      }
                  });

// Set a negative button and its click listener
                  alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialog, int which) {
                          // Your action when Cancel button is clicked
                          dialog.dismiss(); // Close the dialog
                      }
                  });

                  runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          alertDialogBuilder.show();
                      }
                  });
//                  AlertDialog alertDialog = alertDialogBuilder.create();
//                  alertDialogBuilder.show();
                  // Show the Alert Dialog box

                  // Create and show the AlertDialog
                  // Show the Alert Dialog box

              }
            }
        });
    }
}