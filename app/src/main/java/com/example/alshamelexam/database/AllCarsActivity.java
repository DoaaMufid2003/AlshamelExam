package com.example.alshamelexam.database;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.alshamelexam.databinding.ActivityAllCarsBinding;

import java.util.ArrayList;

public class AllCarsActivity extends AppCompatActivity {
ActivityAllCarsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAllCarsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Database database=new Database(getApplicationContext());
        ArrayList<Car>cars=database.getCars();

        cars=database.getCars();
        Log.d("cars", cars.get(1).getColor());
        ArrayList<Car> finalCars = cars;
        CarsAdapter adapter=new CarsAdapter(cars, getApplicationContext(), new listner() {
            @Override
            public void edit(int position) {
                Intent intent=new Intent(getApplicationContext(),AddCarActivity.class);
                intent.putExtra("name", finalCars.get(position).getName().toString());
                intent.putExtra("active", 1);
                intent.putExtra("postion", position);
                intent.putExtra("model", finalCars.get(position).getModel());
                intent.putExtra("color", finalCars.get(position).getColor().toString());
                startActivity(intent);
            }

            @Override
            public void delete(int position) {
                if (database.deleteCar(new Car(position))){
                    Toast.makeText(AllCarsActivity.this, "Delete Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AllCarsActivity.this, "Not", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onClick(String categoryName) {
            }

            @Override
            public void onClickProduct(int id) {

            }
        });
        if (cars.isEmpty()){
            Toast.makeText(this, "Null", Toast.LENGTH_SHORT).show();
        }
        binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        binding.rv.setAdapter(adapter);
    }
}