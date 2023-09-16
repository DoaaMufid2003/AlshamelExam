package com.example.alshamelexam.database;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alshamelexam.databinding.ItemCarBinding;

import java.util.ArrayList;
import java.util.List;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.MyViewHolder> {
    Context context;
    ArrayList<Car> cars;
    listner listner;
    ItemCarBinding binding;
    MyViewHolder viewHolder;
    public CarsAdapter( ArrayList<Car> cars, Context context,listner listner) {
        this.cars=cars;
        this.context = context;
        this.listner=listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         binding=ItemCarBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new  MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
holder.car_model.setText(cars.get(position).getModel()+"");
int pos=position;
holder.car_name.setText(cars.get(position).getName());
holder.car_color.setText(cars.get(position).getColor());
holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        listner.edit(pos);
    }
});
       holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                viewHolder = new MyViewHolder(binding);
                int position = viewHolder.getAdapterPosition();
                listner.delete(pos);
                return true;
            }
        });


    }


    @Override
    public int getItemCount() {
        return cars.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView car_name;
        TextView car_model;
        TextView car_color;
        ImageView imageView;


        public MyViewHolder(@NonNull ItemCarBinding binding) {
            super(binding.getRoot());

            car_color=binding.tvColor;
            car_name= binding.tvName;
            imageView= binding.edit;
            car_model= binding.tvModel;

        }

    }
}
