package com.example.ma_project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ma_project2.students_page.StudentActivity
import com.example.ma_project2.teachers_page.TeacherActivity
import kotlinx.android.synthetic.main.activity_authentification.*

class AuthentificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)

            val bundle:Bundle?=intent.extras
            val status:String? = bundle!!.getString("status")
            var intent2 : Intent
            btn_SignIn.setOnClickListener {
                if (status.equals("teacher")){
                    intent2= Intent(this, TeacherActivity::class.java)
                    startActivity(intent2)
                }else{
                    intent2= Intent(this, StudentActivity::class.java)
                    startActivity(intent2)
                }
            }
    }
}
