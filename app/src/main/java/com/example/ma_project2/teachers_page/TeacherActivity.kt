package com.example.ma_project2.teachers_page

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.ma_project2.R
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        supportActionBar!!.title = "Go Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        see_results_btn.setOnClickListener {
            val intent = Intent(this, SeeResultActivity::class.java)
            startActivity(intent)
        }
        add_questions_btn.setOnClickListener {
            val intent = Intent(this, AddQuestionActivity::class.java)
            startActivity(intent)
        }
    }
}
