package com.example.ma_project2.teachers_page

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.ma_project2.R
import com.example.ma_project2.adapters.AddQustionAdapter
import com.example.ma_project2.model.Predmet
import com.example.ma_project2.model.Result
import kotlinx.android.synthetic.main.activity_add_question.*
import kotlinx.android.synthetic.main.activity_see_result.*

class AddQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation= LinearLayoutManager.VERTICAL
        var results:ArrayList<Predmet> = arrayListOf(Predmet("Math"))
        results.add(Predmet("Programming"))
        results.add(Predmet("Func Analiz"))
        results.add(Predmet("Complex analisys"))
        results.add(Predmet("Predmet1"))
        results.add(Predmet("Predmet2"))
        results.add(Predmet("Predmet3"))
        results.add(Predmet("Predmet4"))
        results.add(Predmet("Predmet5"))
        results.add(Predmet("Predmet6"))
        results.add(Predmet("Predmet7"))
        results.add(Predmet("Predmet8"))
        results.add(Predmet("Programming2"))
        results.add(Predmet("Programming3"))
        results.add(Predmet("Programming4"))
        results.add(Predmet("Programming5"))
        results.add(Predmet("Programming6"))
        recyclerViewAddQuestion.layoutManager=layoutManager
        val adapter = AddQustionAdapter(this,results)
        recyclerViewAddQuestion.adapter=adapter

    }
}
