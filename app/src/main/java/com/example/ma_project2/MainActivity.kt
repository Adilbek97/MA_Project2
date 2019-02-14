package com.example.ma_project2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent= Intent(this,AuthentificationActivity::class.java)
        btn_Teacher.setOnClickListener {
//            Toast.makeText(this,"Button teacher was clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("status","teacher")
            startActivity(intent)
        }
        btn_Student.setOnClickListener {
//            Toast.makeText(this,"Button student was clicked", Toast.LENGTH_LONG).show()
            intent.putExtra("status","student")
            startActivity(intent)
        }
    }
}
