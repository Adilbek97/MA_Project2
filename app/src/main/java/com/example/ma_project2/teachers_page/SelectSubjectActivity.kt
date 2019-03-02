package com.example.ma_project2.teachers_page

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.ma_project2.R
import com.example.ma_project2.adapters.SelectSubjectAdapter
import com.example.ma_project2.models_from_api.Subject
import com.example.ma_project2.network.GetMethods
import com.example.ma_project2.showToast
import kotlinx.android.synthetic.main.activity_select_subject.*

class SelectSubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_subject)
        val bundle:Bundle?=intent.extras!!
        val activity_id:Int? = bundle!!.getInt("activity_id")
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerSelectSubject.layoutManager = layoutManager
//        val subjects: ArrayList<Subject>? = GetMethods.getSubjects()
        val subjects: ArrayList<Subject>? = bundle.getParcelableArrayList<Subject>("subject_key")
        if (subjects != null) {
            val adapter = SelectSubjectAdapter(this, subjects,activity_id!!)
            recyclerSelectSubject.adapter = adapter
        } else {
           /* showToast("we cant get problem with network!!!")
            val adapter = SelectSubjectAdapter(this,  staticValues(),activity_id!!)
            recyclerSelectSubject.adapter = adapter*/

        }
    }
    fun staticValues( ):ArrayList<Subject> {
        var results: ArrayList<Subject> = arrayListOf()
        results.add(Subject(name = "Programming"))
        results.add(Subject(name = "Func Analiz"))
        results.add(Subject(name = "Complex analisys"))
        results.add(Subject(name = "Predmet1"))
        results.add(Subject(name = "Predmet2"))
        results.add(Subject(name = "Predmet3"))
        results.add(Subject(name = "Predmet4"))
        results.add(Subject(name = "Predmet5"))
        results.add(Subject(name = "Predmet6"))
        results.add(Subject(name = "Predmet7"))
        results.add(Subject(name = "Predmet8"))
        results.add(Subject(name = "Programming2"))
        results.add(Subject(name = "Programming3"))
        results.add(Subject(name = "Programming4"))
        results.add(Subject(name = "Programming5"))
        results.add(Subject(name = "Programming6"))
        return results

    }
}
