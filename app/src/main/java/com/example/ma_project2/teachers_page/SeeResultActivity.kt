package com.example.ma_project2.teachers_page

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.ma_project2.R
import com.example.ma_project2.adapters.SeeResultAdapter
import com.example.ma_project2.model.Result
import kotlinx.android.synthetic.main.activity_see_result.*

class SeeResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_result)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation= LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=layoutManager

        var results:ArrayList<Result> = arrayListOf(Result("Math", 90.0))
        results.add(Result("Programming",100.0))
        results.add(Result("Func Analiz",60.5))
        results.add(Result("Complex analisys",80.0))
        results.add(Result("Predmet1",100.0))
        results.add(Result("Predmet2",100.0))
        results.add(Result("Predmet3",100.0))
        results.add(Result("Predmet4",55.0))
        results.add(Result("Predmet5",100.0))
        results.add(Result("Predmet6",75.0))
        results.add(Result("Predmet7",100.0))
        results.add(Result("Predmet8",85.0))
        results.add(Result("Programming2",100.0))
        results.add(Result("Programmin3",100.0))
        results.add(Result("Programmin4",45.0))
        results.add(Result("Programmin5",100.0))
        results.add(Result("Programmin6",100.0))
        results.add(Result("Programmin7",78.4))
        results.add(Result("Programmin8",100.0))
        results.add(Result("Programmin9",100.0))
        results.add(Result("Predmet4",55.0))
        results.add(Result("Predmet5",100.0))
        results.add(Result("Predmet6",75.0))
        results.add(Result("Predmet7",100.0))
        results.add(Result("Predmet8",85.0))
        results.add(Result("Programming2",100.0))
        results.add(Result("Programmin3",100.0))
        results.add(Result("Programmin4",45.0))
        results.add(Result("Programmin5",100.0))
        results.add(Result("Programmin6",100.0))

        val adapter=SeeResultAdapter(this,results)

        recyclerView.adapter=adapter
    }
}
