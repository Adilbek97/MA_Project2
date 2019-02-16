package com.example.ma_project2.teachersPage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.ma_project2.R
import com.example.ma_project2.adapters.AddQuestionAdapter
import com.example.ma_project2.model.Subject
import kotlinx.android.synthetic.main.activity_add_question.*

class AddQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation= LinearLayoutManager.VERTICAL
        var results:ArrayList<Subject> = arrayListOf(Subject("Math"))
        results.add(Subject("Programming"))
        results.add(Subject("Func Analiz"))
        results.add(Subject("Complex analisys"))
        results.add(Subject("Predmet1"))
        results.add(Subject("Predmet2"))
        results.add(Subject("Predmet3"))
        results.add(Subject("Predmet4"))
        results.add(Subject("Predmet5"))
        results.add(Subject("Predmet6"))
        results.add(Subject("Predmet7"))
        results.add(Subject("Predmet8"))
        results.add(Subject("Programming2"))
        results.add(Subject("Programming3"))
        results.add(Subject("Programming4"))
        results.add(Subject("Programming5"))
        results.add(Subject("Programming6"))
        recyclerViewAddQuestion.layoutManager=layoutManager
        val adapter = AddQuestionAdapter(this,results)
        recyclerViewAddQuestion.adapter=adapter

    }
}
