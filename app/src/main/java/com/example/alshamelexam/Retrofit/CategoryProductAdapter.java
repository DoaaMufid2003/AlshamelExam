package com.example.alshamelexam.Retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.alshamelexam.Model.Product;
import com.example.alshamelexam.database.listner;
import com.example.alshamelexam.databinding.CategoryItemBinding;
import com.example.alshamelexam.databinding.CategoryProductItemBinding;

import java.util.List;

public class CategoryProductAdapter extends RecyclerView.Adapter<CategoryProductAdapter.ViewHolder> {
List<Product>products;
Context context;
listner listner;

    public CategoryProductAdapter(List<Product> products, Context context,listner listner) {
        this.products = products;
        this.context = context;
        this.listner=listner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CategoryProductItemBinding binding=CategoryProductItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int pos=position;
holder.title.setText(products.get(position).getTitle());
holder.description.setText(products.get(position).getDescription());
Glide.with(context).load(products.get(position).getThumbnail()).into(holder.imageView);
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        listner.onClickProduct(products.get(pos).getId());
    }
});

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
TextView title;
TextView description;
ImageView imageView;
        public ViewHolder(@NonNull CategoryProductItemBinding binding) {
            super(binding.getRoot());
            title=binding.tvTitle;
            description=binding.tvDescription;
            imageView=binding.imageView;
        }
    }
}
