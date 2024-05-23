package com.dhan_bazar.userlogindetails.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetorfitClient {

    private const val baseUrl = "https://jsonplaceholder.typicode.com/" // Ensure it ends with a forward slash
    private val retrofit by lazy {
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS) // Adjust timeout as needed
            .readTimeout(30, TimeUnit.SECONDS) // Adjust timeout as needed
            .writeTimeout(30, TimeUnit.SECONDS) // Adjust timeout as needed
            .build()

        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiServies: ApiServies by lazy {
        retrofit.create(ApiServies::class.java)
    }

}