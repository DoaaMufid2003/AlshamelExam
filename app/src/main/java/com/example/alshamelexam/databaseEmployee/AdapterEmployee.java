package com.example.alshamelexam.databaseEmployee;

import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alshamelexam.databinding.ItemUserBinding;

import java.util.ArrayList;

public class AdapterEmployee extends RecyclerView.Adapter<AdapterEmployee.ViewHolder> {
    ArrayList<Employee> employees;
    Context context;

    public AdapterEmployee(ArrayList<Employee> employees, Context context) {
        this.employees = employees;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nam.setText(employees.get(position).getName());
        if (employees.get(position).getSalary()>=1000){
            holder.itemView.setBackgroundColor(Color.GREEN);
        }
        else {
            holder.itemView.setBackgroundColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nam;

        public ViewHolder(@NonNull ItemUserBinding binding) {
            super(binding.getRoot());
            nam = binding.tvName;
        }
    }
}
