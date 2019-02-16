package com.example.ma_project2.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ma_project2.R
import com.example.ma_project2.model.Result
import kotlinx.android.synthetic.main.see_result_item.view.*

class SeeResultAdapter(val context:Context,var result: List<Result>): RecyclerView.Adapter<SeeResultAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.see_result_item,p0,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.size-1
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val res:Result= result[p1]
        p0.setData(res,p1)
    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    var curResult:Result? = null
    var curPosition:Int = 0

    fun setData(result:Result?,position:Int){
            this.curResult=result
            this.curPosition=position
            itemView.subject_tv.text=curResult!!.subject
            itemView.mark_tv.text = Math.round(curResult!!.mark).toString()

        }
    }
}


