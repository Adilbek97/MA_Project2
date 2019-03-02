package com.example.ma_project2.network

import com.example.ma_project2.models_from_api.Question
import com.example.ma_project2.models_from_api.Teacher
import retrofit2.Call
import retrofit2.Response

object PostMethods {
    val userService = ServiceBuilder.builService(ApiService::class.java)
    fun addTeacher(teacher: Teacher):Teacher?{
        var teacher1:Teacher?=null
        val requestCall = userService.addTeacher(teacher)
        requestCall.enqueue(object : retrofit2.Callback<Teacher>{
            override fun onFailure(call: Call<Teacher>, t: Throwable) {
                teacher1=null
            }
            override fun onResponse(call: Call<Teacher>, response: Response<Teacher>) {
                teacher1 = response.body()
            }
        })
        return teacher1
    }
    fun addQuestion(question: Question){
        var question:Question? = null
        val requestCall = userService.addQuestion(question!!)
        requestCall.enqueue(object : retrofit2.Callback<Question>{
            override fun onFailure(call: Call<Question>, t: Throwable) {

            }

            override fun onResponse(call: Call<Question>, response: Response<Question>) {
            }

        })

    }
}