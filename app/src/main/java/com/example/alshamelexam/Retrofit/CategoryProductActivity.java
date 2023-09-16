package com.example.alshamelexam.Retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.alshamelexam.Model.CategoryProduct;
import com.example.alshamelexam.Model.Product;
import com.example.alshamelexam.database.listner;
import com.example.alshamelexam.databinding.ActivityCategoryProductBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryProductActivity extends AppCompatActivity {
ActivityCategoryProductBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCategoryProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
String name=getIntent().getStringExtra("categoryName");
ApiServers.Retrofitclass.getRetrofitInstance().getCategoryProduct(name).enqueue(new Callback<CategoryProduct>() {
    @Override
    public void onResponse(Call<CategoryProduct> call, Response<CategoryProduct> response) {
CategoryProductAdapter adapter=new CategoryProductAdapter(response.body().getProducts(), getApplicationContext(), new listner() {
    @Override
    public void edit(int position) {

    }

    @Override
    public void delete(int position) {

    }

    @Override
    public void onClick(String categoryName) {

    }

    @Override
    public void onClickProduct(int id) {
        Intent intent=new Intent(getBaseContext(),ProductIdActivity3.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
});
        Log.d("responce", response.body().toString());
binding.rv.setAdapter(adapter);
binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));
    }

    @Override
    public void onFailure(Call<CategoryProduct> call, Throwable t) {

    }

});
    }
}