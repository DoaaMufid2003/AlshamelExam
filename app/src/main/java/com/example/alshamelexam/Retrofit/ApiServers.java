package com.example.alshamelexam.Retrofit;

import com.example.alshamelexam.Model.CategoryProduct;
import com.example.alshamelexam.Model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiServers {

    @GET("categories")
    Call<List<String>> categories();

   @GET("category/{category_name}")
   Call<CategoryProduct> getCategoryProduct(@Path("category_name") String categoryName);
//
@GET("{id}")
Call<Product> getProductId(@Path("id") int id);
//    @GET ("category/{category_name}")
//    Call<Category_Product_Responce> get_categorios_products(@Path("category_name") String  category_name);
//
//    @GET("{product_id}")
//    Call<Category_Product_Responce.Products> get_products_byId(@Path("product_id") int id);
//
//    @POST("add")
//    Call<Category_Product_Responce> Add_Products(Category_Product_Responce.Products category_product_responce);

    class Retrofitclass{
        static   String  BasrUrl="https://dummyjson.com/products/";
        public static ApiServers getRetrofitInstance(){
            Retrofit retrofit=new Retrofit.Builder().baseUrl(BasrUrl).addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiServers.class);
        }
    }
}
