package com.example.ma_project2.example_for_retrofit.api

import android.widget.Toast
import com.example.ma_project2.MainActivity
import com.example.ma_project2.example_for_retrofit.ExampleModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GettingMethods {
    fun getUser(id:Int){
        val userService= ServiceBuilder.builService(ApiExample::class.java)
        val requestCall = userService.getUser(id)
        requestCall.enqueue(object : retrofit2.Callback<ExampleModel>{

            override fun onResponse(call: Call<ExampleModel>, response: Response<ExampleModel>) {
                if (response.isSuccessful){
                }
            }
            override fun onFailure(call: Call<ExampleModel>, t: Throwable) {

            }

        })
    }
}