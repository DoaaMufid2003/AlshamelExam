package com.example.alshamelexam.Retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.alshamelexam.Model.Product;
import com.example.alshamelexam.databinding.ActivityProductId3Binding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductIdActivity3 extends AppCompatActivity {
ActivityProductId3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProductId3Binding.inflate(getLayoutInflater());
        
        setContentView(binding.getRoot());
ApiServers.Retrofitclass.getRetrofitInstance().getProductId(getIntent().getIntExtra("id", 0)).enqueue(new Callback<Product>() {
    @Override
    public void onResponse(Call<Product> call, Response<Product> response) {
        Glide.with(getBaseContext()).load(response.body().getThumbnail()).into(binding.imageView2);
        binding.tvDesc.setText(response.body().getDescription());
        binding.tvTitle.setText(response.body().getTitle());
    }

    @Override
    public void onFailure(Call<Product> call, Throwable t) {

    }
});
    }
}