package com.dhan_bazar.userlogindetails.Retrofit


import com.dhan_bazar.userlogindetails.UserModelsItem
import com.google.gson.JsonObject
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
interface ApiServies {

    @GET("posts")
    suspend fun getPosts(): Response<List<UserModelsItem>>

}