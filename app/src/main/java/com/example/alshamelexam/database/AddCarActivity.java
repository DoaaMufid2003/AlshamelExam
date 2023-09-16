package com.example.alshamelexam.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alshamelexam.databinding.ActivityAddCarBinding;

public class AddCarActivity extends AppCompatActivity {
ActivityAddCarBinding binding;
    Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddCarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        database=new Database(getBaseContext());
        Intent intent=getIntent();
        if (intent.getIntExtra("active",0)==1){
            binding.button2.setVisibility(View.GONE);
            binding.updateButton.setVisibility(View.VISIBLE);
        }else {
                    binding.updateButton.setVisibility(View.GONE);
        }
        binding.etName.setText(intent.getStringExtra("name"));
        binding.etColor.setText(intent.getStringExtra("color"));
        binding.etNum.setText(intent.getIntExtra("model",0)+"");
//        binding.updateButton.setVisibility(View.GONE);
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Car car=new Car(binding.etName.getText().toString(),Integer.parseInt(binding.etNum.getText().toString()),binding.etColor.getText().toString());
                database.insertCar(car);
                startActivity(new Intent(getBaseContext(),AllCarsActivity.class));
            }
        });
        binding.updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddCarActivity.this, intent.getIntExtra("postion", 0)+"", Toast.LENGTH_SHORT).show();
                if (                database.updateCar(new Car(binding.etName.getText().toString(),Integer.parseInt(binding.etNum.getText().toString()),intent.getIntExtra("postion",0),binding.etColor.getText().toString()))){
                    Toast.makeText(AddCarActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}