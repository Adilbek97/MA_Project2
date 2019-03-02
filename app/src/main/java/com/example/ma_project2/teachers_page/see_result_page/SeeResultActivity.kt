package com.example.ma_project2.teachers_page.see_result_page

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.ma_project2.R
import com.example.ma_project2.adapters.SeeResultAdapter
import com.example.ma_project2.model.Result
import com.example.ma_project2.models_from_api.Student
import com.example.ma_project2.models_from_api.Subject
import com.example.ma_project2.network.GetMethods
import com.example.ma_project2.showToast
import kotlinx.android.synthetic.main.activity_see_result.*
import retrofit2.Call
import retrofit2.Response

class SeeResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_result)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation= LinearLayoutManager.VERTICAL
        recyclerView.layoutManager=layoutManager
        val bundle:Bundle?=intent.extras!!
//        val selected_subject_name:String= bundle!!.getString("subject_name")
//        val selected_subject_id:Int = bundle!!.getInt("subject_id")

        val subject:Subject = bundle!!.getParcelable("subject_key") as Subject
      /*  var results:ArrayList<Result> = arrayListOf(Result(subject.name.toString(), subject.id.toDouble()))
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
        results.add(Result("Programmin6",100.0))*/
        val students:ArrayList<Student>?=GetMethods.getStudents()
        val adapter:SeeResultAdapter? = SeeResultAdapter(this@SeeResultActivity, subject.results!!,students!!)
        recyclerView.adapter=adapter
       /* val requestCall = GetMethods.userService.getStudents()
        requestCall.enqueue(object : retrofit2.Callback<ArrayList<Student>>{
            override fun onFailure(call: Call<ArrayList<Student>>, t: Throwable) {
                showToast("We cant get students . Problem with Internet or something doing uncorrect")
            }

            override fun onResponse(call: Call<ArrayList<Student>>, response: Response<ArrayList<Student>>) {
                students = response.body()
                val adapter:SeeResultAdapter? = SeeResultAdapter(this@SeeResultActivity, subject.results!!,students)
                recyclerView.adapter=adapter
            }

        })*/

    }
}
