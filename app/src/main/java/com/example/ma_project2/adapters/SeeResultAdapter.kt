package com.example.ma_project2.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ma_project2.R
import com.example.ma_project2.models_from_api.Student
import com.example.ma_project2.models_from_api.Result
import kotlinx.android.synthetic.main.see_result_item.view.*


class SeeResultAdapter(val context:Context,var result: ArrayList<Result>, var students:ArrayList<Student>?): RecyclerView.Adapter<SeeResultAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): MyViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.see_result_item,viewGroup,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.size
    }

    override fun onBindViewHolder(myViewHolder: MyViewHolder, position: Int) {
        val res:Result= result[position]
        myViewHolder.setData(res,position)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    var curResult:Result? = null
    var curPositin:Int = 0

    @SuppressLint("SetTextI18n")
    fun setData(result:Result?, position:Int){
            this.curResult=result
            this.curPositin=position
//            students!![position].firstName
            itemView.subject_tv.text=students!![position].lastName +" "+ students!![position].firstName
//            itemView.subject_tv.text=curResult!!.predmet
            itemView.mark_tv.text = Math.round(curResult!!.result).toString()

        }
    }
}


