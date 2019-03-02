package com.example.ma_project2.teachers_page.add_question_page

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.ma_project2.R
import com.example.ma_project2.adapters.SelectSubjectAdapter
import com.example.ma_project2.models_from_api.Question
import com.example.ma_project2.models_from_api.Subject
import com.example.ma_project2.network.GetMethods
import com.example.ma_project2.network.PostMethods
import com.example.ma_project2.showToast
import kotlinx.android.synthetic.main.activity_add_question.*
import retrofit2.Call
import retrofit2.Response

class AddQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
        /*val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation= LinearLayoutManager.VERTICAL
        recyclerViewAddQuestion.layoutManager=layoutManager
        val subjects:ArrayList<Subject>? = GetMethods.getSubjects()
        if (subjects!=null) {
            val adapter = SelectSubjectAdapter(this,subjects,1)
            recyclerViewAddQuestion.adapter=adapter
        }else{
//            staticAdapter()

            showToast("we cant get problem with network!!!")
        }
*/
        var bundle:Bundle = intent.extras!!
        val subject = bundle.getParcelable<Subject>("subject_key")
//        val selected_subject_name:String = bundle.getString("subject_name")
//        val selected_subject_id:Int = bundle.getInt("subject_id")
        subject_name_tv.text = subject!!.name
//        showToast("id of "+subject.name+" "+subject.id)
        save_and_add_more_btn.setOnClickListener {
            var question:Question= Question()
            question.question=question_et.text.toString()
            question.optionA = optionA_et.text.toString()
            question.optionB = optionB_et.text.toString()
            question.optionC = optionC_et.text.toString()
            question.optionD = optionD_et.text.toString()
            question.correctOption = correct_option_et.text.toString()
            question.subject_id = subject.id
            addQuestion(question)

        }
    }

    fun addQuestion(question: Question){
        val requestCall = PostMethods.userService.addQuestion(question)
        requestCall.enqueue(object : retrofit2.Callback<Question>{
            override fun onFailure(call: Call<Question>, t: Throwable) {
                showToast("Error")
            }

            override fun onResponse(call: Call<Question>, response: Response<Question>) {
                showToast("Succesfully added new quetion")
                question.question = " "
                question.optionA = " "
                question.optionB = " "
                question.optionC = " "
                question.optionD = " "
                question.correctOption = " "
            }

        })

    }
}
