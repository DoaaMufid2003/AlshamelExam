package com.example.alshamelexam.Retrofit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alshamelexam.database.listner;
import com.example.alshamelexam.databinding.CategoryItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
List<String> categories;
Context context;
    listner listner;

    public CategoryAdapter(List<String> categories, Context context, com.example.alshamelexam.database.listner listner) {
        this.categories = categories;
        this.context = context;
        this.listner = listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryItemBinding binding=CategoryItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.button.setText(categories.get(position));
    holder.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            listner.onClick(holder.button.getText().toString());
            Log.d("nameCat", holder.button.getText().toString());
        }
    });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        Button button;
        public ViewHolder(@NonNull CategoryItemBinding binding) {
            super(binding.getRoot());
            button=binding.button3;

        }
    }
}
