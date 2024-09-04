package com.example.shopping_list.api

import com.example.shopping_list.model.Product
import retrofit.http.GET
import retrofit.Call

interface ProductService {
    @GET("products")
    fun getProducts() : Call<List<Product>>
}