package com.example.ma_project2.teachers_page

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.ma_project2.R
import com.example.ma_project2.models_from_api.Teacher
import com.example.ma_project2.showToast
import kotlinx.android.synthetic.main.activity_teacher.*

class TeacherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)
        val bundle:Bundle = intent.extras!!
        val teacher:Teacher = bundle.getParcelable("teacher_key") as Teacher
        showToast(teacher.firstName!!)
        title_teacher_tv.text = "Wellcome " + teacher.firstName
        val intent=Intent(this,SelectSubjectActivity::class.java)
        intent.putExtra("subject_key",teacher.subjects)
        see_results_btn.setOnClickListener {
            intent.putExtra("activity_id", 1)
            startActivity(intent)
        }
        add_questions_btn.setOnClickListener {
            intent.putExtra("activity_id", 2)
            startActivity(intent)
        }
    }
}
