package com.example.alshamelexam.databaseEmployee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.alshamelexam.databinding.ActivityEmployeeBinding;

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {
    ActivityEmployeeBinding binding;
    DatabaseEmployee databaseEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEmployeeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseEmployee = new DatabaseEmployee(getApplicationContext());
        binding.btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee = new Employee(binding.etEmplName.getText().toString(), Integer.parseInt(binding.etEmpSalary.getText().toString()));
                databaseEmployee.insertEmployee(employee);
            }
        });
        binding.rbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdapterEmployee adapterEmployee = new AdapterEmployee(databaseEmployee.getEmployees(), getBaseContext());
                binding.rv.setAdapter(adapterEmployee);
                binding.rv.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));
                adapterEmployee.notifyDataSetChanged();
            }
        });
        binding.rbLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Employee> employees=new ArrayList<>();
                for (int i = 0; i < databaseEmployee.getEmployees().size() ; i++) {
                if (databaseEmployee.getEmployees().get(i).getSalary()<1000){
                    employees.add(databaseEmployee.getEmployees().get(i));
                }
                }

                AdapterEmployee adapterEmployee = new AdapterEmployee(employees, getBaseContext());
                binding.rv.setAdapter(adapterEmployee);
                binding.rv.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));
                adapterEmployee.notifyDataSetChanged();
            }
        });
        binding.rbMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Employee> employees=new ArrayList<>();
                for (int i = 0; i < databaseEmployee.getEmployees().size() ; i++) {
                    if (databaseEmployee.getEmployees().get(i).getSalary()>=1000){
                        employees.add(databaseEmployee.getEmployees().get(i));
                    }
                }

                AdapterEmployee adapterEmployee = new AdapterEmployee(employees, getBaseContext());
                binding.rv.setAdapter(adapterEmployee);
                binding.rv.setLayoutManager(new LinearLayoutManager(getBaseContext(), RecyclerView.VERTICAL, false));
                adapterEmployee.notifyDataSetChanged();
            }
        });
    }
}