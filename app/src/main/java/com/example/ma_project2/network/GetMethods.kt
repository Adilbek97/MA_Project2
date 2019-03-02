package com.example.ma_project2.network

import com.example.ma_project2.models_from_api.Student
import com.example.ma_project2.models_from_api.Subject
import com.example.ma_project2.models_from_api.Teacher
import retrofit2.Call
import retrofit2.Response

object GetMethods {
    val userService = ServiceBuilder.builService(ApiService::class.java)

    // for subject
        fun getSubjects(): ArrayList<Subject>? {
            var subjects: ArrayList<Subject>? = null
            val requestCall = userService.getSubjects()
            requestCall.enqueue(object : retrofit2.Callback<ArrayList<Subject>> {
                override fun onFailure(call: Call<ArrayList<Subject>>, t: Throwable) {
                    subjects = null
                }
                override fun onResponse(call: Call<ArrayList<Subject>>, response: Response<ArrayList<Subject>>) {
                    subjects = response.body()
                }
            })
            return subjects
        }

        fun getStudents():ArrayList<Student>?{
            var students:ArrayList<Student>?=null
            val requestCall = userService.getStudents()
            requestCall.enqueue(object : retrofit2.Callback<ArrayList<Student>>{
                override fun onFailure(call: Call<ArrayList<Student>>, t: Throwable) {

                }

                override fun onResponse(call: Call<ArrayList<Student>>, response: Response<ArrayList<Student>>) {
                    students = response.body()
                }

            })
            return students
        }

        fun getSubject(id:Int):Subject?{
            var subject:Subject? = null
            val requestCall = userService.getSubject(id)
            requestCall.enqueue(object : retrofit2.Callback<Subject>{
                override fun onFailure(call: Call<Subject>, t: Throwable) {
                    subject=null
                }
                override fun onResponse(call: Call<Subject>, response: Response<Subject>) {
                    subject = response.body()
                }
            })
            return subject
        }

        fun getTeacherByLogin(login:String,password:String?):ArrayList<Teacher>?{
            var teacher:ArrayList<Teacher>?=null
            val requestCall = userService.getTeacherByLogin(login,password)
            requestCall.enqueue(object : retrofit2.Callback<ArrayList<Teacher>>{
                override fun onFailure(call: Call<ArrayList<Teacher>>, t: Throwable) {
                    teacher=null
                }
                override fun onResponse(call: Call<ArrayList<Teacher>>, response: Response<ArrayList<Teacher>>) {
                    teacher = response.body()
                }
            })
            return teacher
        }
}


