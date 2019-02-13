package com.example.ma_project2.example_for_retrofit.api

import com.example.ma_project2.example_for_retrofit.ExampleModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {
    companion object {
        val retrofit: Retrofit
            get() = Retrofit.Builder()
                .baseUrl(ApiExample.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

}
