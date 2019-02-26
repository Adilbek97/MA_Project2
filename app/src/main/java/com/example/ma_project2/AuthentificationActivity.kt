package com.example.ma_project2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ma_project2.students_page.StudentActivity
import com.example.ma_project2.teachers_page.TeacherActivity
import kotlinx.android.synthetic.main.activity_authentification.*

class AuthentificationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val status: String?
        val bundle: Bundle? = intent.extras
        if (bundle != null){
            status = bundle.getString("status")
        }else{
            status = "teacher"
        }
        var intent2: Intent
        btn_SignIn.setOnClickListener {
            if (status.equals("teacher")) {
                intent2 = Intent(this, TeacherActivity::class.java)
                startActivity(intent2)
            } else {
                intent2 = Intent(this, StudentActivity::class.java)
                startActivity(intent2)
            }
        }
    }
}
