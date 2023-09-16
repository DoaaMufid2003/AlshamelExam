package com.example.alshamelexam.Retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.alshamelexam.database.listner;
import com.example.alshamelexam.databinding.ActivityCategoriesBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {
ActivityCategoriesBinding binding;
ApiServers servers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        servers=ApiServers.Retrofitclass.getRetrofitInstance();
        servers.categories().enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                CategoryAdapter adapter=new CategoryAdapter(response.body(), getApplicationContext(), new listner() {
                    @Override
                    public void edit(int position) {

                    }

                    @Override
                    public void delete(int position) {

                    }

                    @Override
                    public void onClick(String categoryName) {
                        Log.d("name", categoryName);
                        Intent intent=new Intent(getBaseContext(),CategoryProductActivity.class);
                        intent.putExtra("categoryName", categoryName);
                        startActivity(intent);
                    }

                    @Override
                    public void onClickProduct(int id) {

                    }
                });
                binding.rv.setAdapter(adapter);
                binding.rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL,false));
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }
}