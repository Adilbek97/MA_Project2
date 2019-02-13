package com.example.ma_project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ma_project2.example_for_retrofit.ExampleModel
import com.example.ma_project2.example_for_retrofit.api.ApiExample
import com.example.ma_project2.example_for_retrofit.api.Client
import com.example.ma_project2.example_for_retrofit.api.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent= Intent(this,AuthentificationActivity::class.java)
        val apiExample = Client.retrofit.create(ApiExample::class.java)
        bTeacher.setOnClickListener {
            intent.putExtra("status","teacher")
            /*
            Toast.makeText(this,"Button teacher was clicked", Toast.LENGTH_LONG).show()

            val users = apiExample.users
            users.enqueue(object : retrofit2.Callback<List<ExampleModel>> {
                override fun onResponse(call: Call<List<ExampleModel>>, response: Response<List<ExampleModel>>) {

                }

                override fun onFailure(call: Call<List<ExampleModel>>, t: Throwable) {

                }
            })*/
            getUser(4)
//            startActivity(intent)
        }
        bStudent.setOnClickListener {
//            Toast.makeText(this,"Button student was clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("status","student")
            val exampleModel=ExampleModel()
            exampleModel.name="Sergey"
            exampleModel.age=34
            apiExample.savePost(exampleModel).enqueue(object :retrofit2.Callback<ExampleModel>{

                override fun onResponse(call: Call<ExampleModel>, response: Response<ExampleModel>) {
                    showToast("Bence koshuldu "+response.body().toString())
                }

                override fun onFailure(call: Call<ExampleModel>, t: Throwable) {
                    showToast("Error from post request")
                }

            })

//            startActivity(intent)
        }
    }



    fun loadAllUsers(){
        val userService = ServiceBuilder.builService(ApiExample::class.java)
        val requestCall = userService.users
        requestCall.enqueue(object : retrofit2.Callback<List<ExampleModel>>{

            override fun onResponse(call: Call<List<ExampleModel>>, response: Response<List<ExampleModel>>) {
                if(response.isSuccessful){
                Log.d("FromInternet","keldi"+ response.body()!!.get(0).name)
                showToast("internetten otvet keldi"+response.body()!!.get(1).name)
                }else{
                    showToast("Failed to retrive items , with code : "+response.code().toString())
                }
            }

            override fun onFailure(call: Call<List<ExampleModel>>, t: Throwable) {
                showToast("internetten kelgen jok kata ")
            }

        })
    }

    fun getUser(id:Int){
//        showToast("getUser")
        val userService= ServiceBuilder.builService(ApiExample::class.java)
        val requestCall = userService.getUser(id)
        requestCall.enqueue(object : retrofit2.Callback<ExampleModel>{
            override fun onFailure(call: Call<ExampleModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<ExampleModel>, response: Response<ExampleModel>) {
                showToast("geldi")
            }


        })
    }


}


