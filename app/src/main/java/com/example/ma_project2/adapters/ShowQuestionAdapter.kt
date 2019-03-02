package com.example.ma_project2.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.ma_project2.models_from_api.Question

class ShowQuestionAdapter(val context: Context,var question:ArrayList<Question>){

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var currentQuestion:Question?=null
        var currentPosition:Int= 0
        fun setData(question: Question?,position:Int){
            this.currentPosition = position
            this.currentQuestion = question



        }
    }
}