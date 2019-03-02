package com.example.ma_project2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ma_project2.models_from_api.Question
import com.example.ma_project2.models_from_api.Result
import com.example.ma_project2.models_from_api.Subject
import com.example.ma_project2.models_from_api.Teacher
import com.example.ma_project2.network.PostMethods
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        register_btn.setOnClickListener {
            val firstname: String? = first_name_edit_text.text.toString()
            val lastname: String? = last_name_edit_text.text.toString()
            val login: String? = login_edit_text.text.toString()
            val password: String? = password_edit_text.text.toString()
            val password_again: String? = password_again_edit_text.text.toString()
            val error = checkErrors(firstname, lastname, login, password, password_again)
            if (error.equals("correct")) {
                var teacher:Teacher= Teacher()
                teacher.firstName=firstname
                teacher.lastName=lastname
                teacher.login=login
                teacher.password=password
/*
//                var subject:Subject= Subject()
//                subject.name="default"
//                var question:Question = Question()
//                question.question="default Question from Techer"
//                question.correctOption="a"
//                question.optionA="optionA"
//                question.optionB="optionB"
//                question.optionC="optionC"
//                question.optionD="optionD"
////                question.subject=3
//                val listQuestion = arrayListOf<Question>(question)
//                subject.questions=listQuestion
//
//                var result:Result= Result()
//                result.result=97.5
//                result.student=2
//                result.subject=3
//
//                val listResult = arrayListOf<Result>(result)
//                subject.results=listResult
//
//
//                var listSubject = arrayListOf<Subject>(subject)
//
//                teacher.subjects = listSubject
//
*/
                if(PostMethods.addTeacher(teacher)!=null){
                    show_errors_tv.text = "succesfully added"
                }else{
                    show_errors_tv.text = "can't add"
                }
            } else {
                show_errors_tv.text = error
            }
        }
    }

    fun checkErrors(
        firstname: String?,
        lastname: String?,
        login: String?,
        password: String?,
        password_again: String?
    ): String {
        if (firstname.equals(null) || firstname.equals("")) {
            return "please write firstname"
        }
        if (lastname.equals(null) || lastname.equals("")) {
            return "please write lastname"
        }
        if (login.equals(null) || login.equals("")) {
            return "please write login"
        }
        if (password.equals(null) || password.equals("")) {
            return "please write password"
        }
        if (password_again.equals(null) || password_again.equals("")) {
            return "please write password_again"
        }
        if (!password.equals(password_again)) {
            return "passwords not equal"

        }
        return "correct"
    }

}
