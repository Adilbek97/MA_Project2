package com.example.ma_project2.network

import android.telecom.Call
import com.example.ma_project2.models_from_api.Question
import com.example.ma_project2.models_from_api.Student
import com.example.ma_project2.models_from_api.Subject
import com.example.ma_project2.models_from_api.Teacher
import retrofit2.http.*

interface ApiService {
    // actions for teacher
        @GET("api/teachers/")
        fun getTeachers():retrofit2.Call<ArrayList<Teacher>>

        @POST("api/teachers/")
        fun addTeacher(@Body teacher: Teacher): retrofit2.Call<Teacher>

        @GET("/api/teachers/")
        fun getTeacherByLogin(@Query("login")login:String,@Query("password")password:String?):retrofit2.Call<ArrayList<Teacher>>

    //actions for student
        @GET("api/students/")
        fun getStudents():retrofit2.Call<ArrayList<Student>>

        @GET("api/students/{id}/")
        fun getStudent(@Path("id")id:Int):retrofit2.Call<Student>

        @GET("api/students/")
        fun getStudentByLogin(@Query("login")login:String,@Query("password")password:String?):retrofit2.Call<ArrayList<Student>>

    //actions for subjects

        @GET("api/subjects/")
        fun getSubjects():retrofit2.Call<ArrayList<Subject>>

        @GET("api/subjects/{id}/")
        fun getSubject(@Path("id")id:Int):retrofit2.Call<Subject>

    //actions for questions

        @POST("api/questions/")
        fun addQuestion(@Body question: Question):retrofit2.Call<Question>



}