package com.example.shopping_list.api


import android.content.Context
import android.widget.Toast
import com.example.shopping_list.R
import com.example.shopping_list.model.Product
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import javax.inject.Inject

class RemoteProductService @Inject constructor() {

    fun getProducts(context: Context,
                    onSuccess: (List<Product>)-> Unit,
                    onFail: ()-> Unit,
                    loadingFinished: ()-> Unit){
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(
                context.getString(R.string.api_url)
            )
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        val service: ProductService = retrofit.create(ProductService::class.java)

        val call: Call<List<Product>> = service.getProducts()

        call.enqueue(object : Callback<List<Product>>{
            override fun onResponse(response: Response<List<Product>>?, retrofit: Retrofit?) {
                loadingFinished()
                if(response?.isSuccess == true) {
                    val products: List<Product> = response.body()
                    onSuccess(products)
                } else {
                    onFailure(Exception("Bad request"))
                }
            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, context.getString(R.string.error_cant_get_products), Toast.LENGTH_SHORT).show()
                onFail()
                loadingFinished()
            }
        }
        )
    }
}