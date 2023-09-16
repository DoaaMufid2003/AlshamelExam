package com.example.alshamelexam.databaseUser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.alshamelexam.databinding.ActivityAllUsersBinding;

import java.util.ArrayList;

public class AllUsersActivity extends AppCompatActivity {
ActivityAllUsersBinding binding;
database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database=new database(getBaseContext());
        ArrayList<User> users=database.getAllUsers();
        UserAdapter adapter=new UserAdapter(users,getBaseContext());
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL,false));
    }
}