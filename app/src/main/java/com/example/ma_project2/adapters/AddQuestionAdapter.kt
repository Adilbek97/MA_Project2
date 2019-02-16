package com.example.ma_project2.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ma_project2.R
import com.example.ma_project2.model.Subject
import kotlinx.android.synthetic.main.see_result_item.view.*

class AddQuestionAdapter(val context: Context, var result: List<Subject>): RecyclerView.Adapter<AddQuestionAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.see_result_item,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.size-1
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val res: Subject? = result[p1]
        p0.setData(res,p1)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var curRredmet: Subject? = null
        var curPositin:Int = 0

            init {
                itemView.setOnClickListener {
                    Toast.makeText(context,curRredmet!!.name+" clicked",Toast.LENGTH_SHORT).show()
                }
            }

        fun setData(predmet: Subject?, position:Int){
            this.curRredmet=predmet
            this.curPositin=position
            itemView.subject_tv.text=curRredmet!!.name

        }
    }
}


