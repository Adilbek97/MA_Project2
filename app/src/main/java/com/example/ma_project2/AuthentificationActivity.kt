package com.example.ma_project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ma_project2.models_from_api.Student
import com.example.ma_project2.models_from_api.Teacher
import com.example.ma_project2.network.GetMethods
import com.example.ma_project2.students_page.StudentActivity
import com.example.ma_project2.teachers_page.TeacherActivity
import kotlinx.android.synthetic.main.activity_authentification.*
import retrofit2.Call
import retrofit2.Response
import java.util.*

class AuthentificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)
        val bundle: Bundle? = intent.extras
        val status: String? = bundle!!.getString("status")
        var intent2: Intent
        SignIn_btn.setOnClickListener {

            if (status.equals("teacher")) {
                intent2 = Intent(this, TeacherActivity::class.java)
                authenticateTeacherByLogin(authenticate_login_edit_text.text.toString(), null, intent2)
//                    startActivity(intent2)
            } else {
                intent2 = Intent(this, StudentActivity::class.java)
                authenticateStudentByLogin(authenticate_login_edit_text.text.toString(), null, intent2)
//                    startActivity(intent2)
            }
        }
        text_or_register_now.setOnClickListener {
            intent2 = Intent(this, RegisterActivity::class.java)
            startActivity(intent2)
        }
    }

    fun authenticateTeacherByLogin(login: String, password: String?, intent: Intent) {
        var requestCall = GetMethods.userService.getTeacherByLogin(login, password)
        requestCall.enqueue(object : retrofit2.Callback<ArrayList<Teacher>> {
            override fun onFailure(call: Call<ArrayList<Teacher>>, t: Throwable) {
                showToast("No login like this ")
            }

            override fun onResponse(call: Call<ArrayList<Teacher>>, response: Response<ArrayList<Teacher>>) {
                var teacher: ArrayList<Teacher> = response.body()!!
                if (authenticate_password_edit_text.text.toString().equals(teacher.get(0).password)) {
                    intent.putExtra("teacher_key", teacher.get(0))
                    startActivity(intent)
                    showToast("wellcome teacher " + teacher.get(0).firstName)
                } else {
                    showToast("password is not correct")
                }
            }
        })
    }

    fun authenticateStudentByLogin(login: String, password: String?, intent: Intent) {
        var requestCall = GetMethods.userService.getStudentByLogin(login, password)
        requestCall.enqueue(object : retrofit2.Callback<ArrayList<Student>> {
            override fun onFailure(call: Call<ArrayList<Student>>, t: Throwable) {
                showToast("No login like this ")
            }

            override fun onResponse(call: Call<ArrayList<Student>>, response: Response<ArrayList<Student>>) {
                var student: ArrayList<Student> = response.body()!!
                if (authenticate_password_edit_text.text.toString().equals(student.get(0).password)) {
                    intent.putExtra("student", student)
                    startActivity(intent)
                    showToast("wellcome student " + student.get(0).firstName)
                } else {
                    showToast("password is not correct")
                }
            }
        })
    }


}
