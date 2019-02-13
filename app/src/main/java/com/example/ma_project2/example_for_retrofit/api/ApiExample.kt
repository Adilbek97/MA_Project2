package com.example.ma_project2.example_for_retrofit.api

import com.example.ma_project2.example_for_retrofit.ExampleModel
import retrofit2.Call
import retrofit2.http.*

interface ApiExample {
    @get:GET("getAll/")
    val users: Call<List<ExampleModel>>

    @POST("users/")
    @FormUrlEncoded
    fun savePost(@Body post: ExampleModel): Call<ExampleModel>

    @GET("get/{id}")
    fun getUser(@Path("id")id:Int):Call<ExampleModel>

    companion object {
        val BASE_URL = "http://96ecf854.ngrok.io/"
    }
}
